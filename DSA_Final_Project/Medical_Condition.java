package DSA_Final_Project;

import java.io.Serializable;

public class Medical_Condition implements Serializable {
    private String Med_Con;
    private String altName;
    private int severity;
    Triage triage;
    public Medical_Condition(String Med_Con, String altName, int severity, Triage triage) {
        this.Med_Con = Med_Con;
        this.altName = altName;
        this.severity = severity;
        this.triage = triage;
    }
    public String getMD() {
        return this.Med_Con;
    }

    public int getSeverity() {
        return this.severity;
    }
    public Triage getTriage() {
        return this.triage;
    }
}
