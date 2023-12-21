package DSA_Final_Project;

import java.io.*;
import java.util.*;

public class Patient_Management_System {
    Resource_Allocation_Optimization RAO = null;
    private List<Patient> patient_Records = new LinkedList<>();
    Comparator<Patient> priorityComparator = new Comparator<Patient>(){
        @Override
        public int compare(Patient o1, Patient o2) {
            return o2.getSeverity() - o1.getSeverity();
        }
    };
    PriorityQueue<Patient> triageQueue = new PriorityQueue<>(priorityComparator);
    PriorityQueue<Patient> patientTemp;
    public Patient_Management_System() {
        File patientFile = new File(".\\DSA_Final_Project\\Patient.ser");
        try {
            if (patientFile.exists() && patientFile.length() > 0) {
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(".\\DSA_Final_Project\\Patient.ser"))) {
                    List<Patient> deserializedAnimals = (List<Patient>) inputStream.readObject();
                    for (Patient patient : deserializedAnimals) {
                        addPatient(patient);
                        prioritizePatients(patient);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                patientFile.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File medConFile = new File(".\\DSA_Final_Project\\MedicalResources.ser");
        if (medConFile.exists() && medConFile.length() > 0) {
            try (FileInputStream fileInasdasda = new FileInputStream(".\\DSA_Final_Project\\MedicalResources.ser");
                 ObjectInputStream objectIn = new ObjectInputStream(fileInasdasda)) {
                this.RAO = (Resource_Allocation_Optimization) objectIn.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            this.RAO = new Resource_Allocation_Optimization();
        }
    }

    public void serialize_patient() {
        if (!triageQueue.isEmpty()) {
            try (FileOutputStream fileOut = new FileOutputStream(".\\DSA_Final_Project\\Patient.ser");
                 ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
                objectOut.writeObject(patient_Records);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (ObjectOutputStream RAOwriter = new ObjectOutputStream(new FileOutputStream(".\\DSA_Final_Project\\MedicalResources.ser"))) {
            RAOwriter.writeObject(RAO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPatient(Patient x) {
        patient_Records.add(x);
    }

    public void prioritizePatients(Patient x) {
        triageQueue.add((x));
    }

    public void displayPatient() {
        patientTemp = new PriorityQueue<>(triageQueue);
        while(!patientTemp.isEmpty()) {
            Patient x = patientTemp.poll();
            System.out.println(x.getPatientInfo() + "\n");
        }
    }

    public void resource_Allocation() {
        patientTemp = new PriorityQueue<>(triageQueue);
        while(!patientTemp.isEmpty()) {
            Patient x = patientTemp.poll();
            if (!x.getAllocStats()) {
                RAO.allocateStaff(x);
            }
            System.out.println(x.getPatientInfo() + x.getAlloc());
        }
    }

    public void generateReport(String sortBy) {
        List<Patient> tempPatients = new ArrayList<>(patient_Records);
        List<Patient> sorted = null;
        if (sortBy.equalsIgnoreCase("name")) {
            sorted = mergeSort(new ArrayList<>(tempPatients), Comparator.comparing(person -> person.getName().toLowerCase()));
        } else if (sortBy.equalsIgnoreCase("age")) {
            sorted = mergeSort(new ArrayList<>(tempPatients), Comparator.comparing(Patient::getAge));
        }
        assert sorted != null;
        printReport(sorted, sortBy);

    }
    public void printReport(List<Patient> patients, String sortBy) {
        if (sortBy.equalsIgnoreCase("name")) {
            System.out.println("------------REPORT BY NAME---------------");

        } else if (sortBy.equalsIgnoreCase("age")) {
            System.out.println("------------REPORT BY AGE---------------");
        }

        for (Patient p : patients) {
            System.out.println(p.getPatientInfo() + "\n");
        }
    }

    public static List<Patient> mergeSort(List<Patient> people, Comparator<Patient> comparator) {
        return mergeSortHelper(new ArrayList<Patient>(people), comparator);
    }

    public static List<Patient> mergeSortHelper(List<Patient> people, Comparator<Patient> comparator) {
        if (people.size() <= 1) {
            return people;
        }

        int mid = people.size() / 2;
        List<Patient> left = mergeSortHelper(new ArrayList<>(people.subList(0, mid)), comparator);
        List<Patient> right = mergeSortHelper(new ArrayList<>(people.subList(mid, people.size())), comparator);

        return merge(left, right, comparator);
    }

    public static List<Patient> merge(List<Patient> left, List<Patient> right, Comparator<Patient> comparator) {
        List<Patient> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex++));
        }
        return merged;
    }
}
