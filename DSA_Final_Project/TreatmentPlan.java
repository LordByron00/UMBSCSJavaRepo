package DSA_Final_Project;

import java.io.Serializable;
import java.util.ArrayList;

// TreatmentPlan class to store patient's treatment plan
class TreatmentPlan implements Serializable {
    private ArrayList<String> medications;
    private ArrayList<String> procedures;
    private ArrayList<String> therapies;
    private String additionalNotes;

    public TreatmentPlan() {
        this.medications = new ArrayList<>();
        this.procedures = new ArrayList<>();
        this.therapies = new ArrayList<>();
        this.additionalNotes = "";
    }


    public void addMedication(String medication) {
        medications.add(medication);
    }

    public void addProcedure(String procedure) {
        procedures.add(procedure);
    }

    public void addTherapy(String therapy) {
        therapies.add(therapy);
    }

    public void setAdditionalNotes(String notes) {
        this.additionalNotes = notes;
    }


    public ArrayList<String> getMedications() {
        return medications;
    }

    public ArrayList<String> getProcedures() {
        return procedures;
    }

    public ArrayList<String> getTherapies() {
        return therapies;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }
}
