package DSA_Carlo;

import java.util.*;

public class Management {
    List<People> people_List = new LinkedList<>();
    Comparator<People> priorityComparator = new Comparator<People>(){
        @Override
        public int compare(People a, People b) {
            return a.getPriority().ordinal() - b.getPriority().ordinal();
        }
    };
    PriorityQueue<People> TQ = new PriorityQueue<>(priorityComparator);
    PriorityQueue<People> peopleTemp;
    int BedMax = 100;
    int hospital_Bed = 100;

    public void addPatient(People people) {
        people_List.add(people);
        TQ.add(people);
    }

    public void patientQueue() {
        peopleTemp = new PriorityQueue<>(TQ);
        while(!peopleTemp.isEmpty()) {
            People x = peopleTemp.poll();
            System.out.println(x.getInfo() + "\n");
        }
    }

    public void allocation() {
        peopleTemp = new PriorityQueue<>(TQ);
        while(!peopleTemp.isEmpty()) {
            People x = peopleTemp.poll();
            if (!x.getAlloc()) {
                String alloc = null;
                int bedNum;
                if (this.hospital_Bed > 0) {
                    switch (x.getPriority().ordinal()) {
                        case 0:
                            alloc = "Doctor";
                            break;
                        case 1:
                            alloc = "Physician";
                            break;
                        case 2:
                            alloc = "Physician Assistant";
                            break;
                        case 3:
                            alloc = "Nurse";
                            break;
                        default:
                            alloc = "Unavailable";
                            break;
                    }
                    if (alloc != null) {
                        hospital_Bed -= 1;
                        bedNum = (BedMax - this.hospital_Bed);
                        x.setBed(bedNum);
                        x.setStaff(alloc);
                        x.setAlloc();
                    }
                }
            }
            System.out.println(x.getInfo() + x.assignedInfo());
        }
        String alloc = null;

    }
    public void reportGen(String sortBy) {
        MergeSort x = new MergeSort();
        List<People> tempPeople = new ArrayList<>(people_List);
        List<People> sorted = null;
        if (sortBy.equalsIgnoreCase("name")) {
            sorted = x.mergeSort(new ArrayList<>(tempPeople), Comparator.comparing(person -> person.getName().toLowerCase()));
        } else if (sortBy.equalsIgnoreCase("age")) {
            sorted = x.mergeSort(new ArrayList<>(tempPeople), Comparator.comparingInt(person -> person.getAge()));
        }
        assert sorted != null;
        printReport(sorted, sortBy);
    }

    public void printReport(List<People> people, String sortBy) {
        if (sortBy.equalsIgnoreCase("name")) {
            System.out.println("REPORT BY NAME:");

        } else if (sortBy.equalsIgnoreCase("age")) {
            System.out.println("REPORT BY AGE:");
        }

        for (People p : people) {
            System.out.println(p.getInfo() + "\n");
        }
    }


}
