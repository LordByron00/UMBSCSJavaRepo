package DSA_Final_Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Medical_History implements Serializable {
    private ArrayList<String> pastDiagnoses;
    private ArrayList<String> currentMedications;
    private ArrayList<String> allergies;
    private ArrayList<String> surgeries;
    private ArrayList<String> immunizations;
    private Date lastCheckupDate;

    public Medical_History() {
        this.pastDiagnoses = new ArrayList<>();
        this.currentMedications = new ArrayList<>();
        this.allergies = new ArrayList<>();
        this.surgeries = new ArrayList<>();
        this.immunizations = new ArrayList<>();
        this.lastCheckupDate = null;
    }
}
