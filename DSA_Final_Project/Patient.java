package DSA_Final_Project;

import java.io.Serializable;

public class Patient implements Serializable {
    private String name;
    private int age;

    Triage triage;
    private int bedNum;
    private String assignedStaff;
    private Medical_Condition med_Con;
    private int severity;
    private boolean allocated;
    Medical_History MH;
    TreatmentPlan TP;
    public Patient(String name, int age, Medical_Condition med_Con) {
        this.name = name;
        this.age = age;
        this.med_Con = med_Con;
        this.severity = med_Con.getSeverity();
        this.triage = med_Con.getTriage();
//        this.MH = MH;
//        this.TP = TP;
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public Medical_Condition getMed_Con() {
        return this.med_Con;
    }
    public int getSeverity() {
        return this.severity;
    }

    public void setAllocStats() {
        this.allocated = true;
    }
    public boolean getAllocStats() {
        return this.allocated;
    }
    public Triage getPriority() {
        return this.triage;
    }

    public void setBedNum(int x) {
        this.bedNum = x;
    }

    public void setMedicalStaff(String x) {
        this.assignedStaff = x;
    }

    public String getAlloc() {
        return "\nBed #:" + this.bedNum + "\nMedical Staff: " + this.assignedStaff + "\n";
    }

    public String getPatientInfo() {
        String info = "Name: " + this.name + "\n" + "Age: " + this.age + "\nMedical Condition: " + this.med_Con.getMD() + "\nPriority: " + this.getPriority();
        return info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }




}
