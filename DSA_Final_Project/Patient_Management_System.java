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
                try (ObjectInputStream IS = new ObjectInputStream(new FileInputStream(".\\DSA_Final_Project\\Patient.ser"))) {
                    List<Patient> deserializedAnimals = (List<Patient>) IS.readObject();
                    for (Patient patient : deserializedAnimals) {
                        patientEntry(patient);
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
            try (FileInputStream fileResources = new FileInputStream(".\\DSA_Final_Project\\MedicalResources.ser");
                 ObjectInputStream OI = new ObjectInputStream(fileResources)) {
                this.RAO = (Resource_Allocation_Optimization) OI.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            this.RAO = new Resource_Allocation_Optimization();
        }
    }

    public void serialize_patient() {
        if (!triageQueue.isEmpty()) {
            try (FileOutputStream patientFile = new FileOutputStream(".\\DSA_Final_Project\\Patient.ser");
                 ObjectOutputStream OO = new ObjectOutputStream(patientFile)) {
                OO.writeObject(patient_Records);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (ObjectOutputStream RAOOOS = new ObjectOutputStream(new FileOutputStream(".\\DSA_Final_Project\\MedicalResources.ser"))) {
            RAOOOS.writeObject(RAO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void patientEntry(Patient x) {
        patient_Records.add(x);
        triageQueue.add((x));

    }

    public void displayPatientQueue() {
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
            sorted = mergeSort(new ArrayList<>(tempPatients), Comparator.comparing(Patient -> Patient.getName().toLowerCase()));
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

    public static List<Patient> mergeSort(List<Patient> patients, Comparator<Patient> cmptr) {
        return mergeSortHelper(new ArrayList<Patient>(patients), cmptr);
    }

    public static List<Patient> mergeSortHelper(List<Patient> patients, Comparator<Patient> cmptr) {
        if (patients.size() <= 1) {
            return patients;
        }

        int mid = patients.size() / 2;
        List<Patient> L = mergeSortHelper(new ArrayList<>(patients.subList(0, mid)), cmptr);
        List<Patient> R = mergeSortHelper(new ArrayList<>(patients.subList(mid, patients.size())), cmptr);

        return merge(L, R, cmptr);
    }

    public static List<Patient> merge(List<Patient> L, List<Patient> R, Comparator<Patient> cmptr) {
        List<Patient> merged = new ArrayList<>();
        int LIX = 0;
        int RIX = 0;

        while (LIX < L.size() && RIX < R.size()) {
            if (cmptr.compare(L.get(LIX), R.get(RIX)) <= 0) {
                merged.add(L.get(LIX++));
            } else {
                merged.add(R.get(RIX++));
            }
        }

        while (LIX < L.size()) {
            merged.add(L.get(LIX++));
        }
        while (RIX < R.size()) {
            merged.add(R.get(RIX++));
        }
        return merged;
    }
}
