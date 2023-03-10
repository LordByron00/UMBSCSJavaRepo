package crudfilejava;

import java.beans.Transient;
import java.io.Serializable;

public class students implements Serializable {
    int SID;
    String Sname;
    int math, science, english, Filipino, Social_Studies, average, classSum, classAvg;

    students(int SID, String Sname, int math, int science, int english, int Filipino, int Social_Studies, int average) {
        this.SID = SID;
        this.Sname = Sname;
        this.math = math;
        this.science = science;
        this.english = english;
        this.Filipino = Filipino;
        this.Social_Studies = Social_Studies;
        this.average = average;
    }

    public String toString() {
        return SID + " " + Sname + " " + math + " " + science + " " + english + " " + Filipino + " " + Social_Studies;
    }
}

