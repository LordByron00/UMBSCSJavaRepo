package DSA_Final_Project;

import java.io.Serializable;

public class Resource_Allocation_Optimization implements Serializable {
    private int hospital_Bed;
    private int max = 100;
    private int Doctors;
    private int Nurses;
    private int Physician_Assistant;
    private int nurse_Practitioner;

    public Resource_Allocation_Optimization() {
        this.hospital_Bed = 100;
        this.Doctors = 24;
        this.Nurses = 50;
        this.Physician_Assistant = 16;
        this.nurse_Practitioner = 40;
    }

    public void allocateStaff(Patient x) {
        String alloc = null;
        int bedNum;
        if (this.hospital_Bed > 0) {
            switch (x.getPriority().ordinal()) {
                case 0:
                    alloc = "Doctor";
                    break;
                case 1:
                    alloc = "Physician Assistant";
                    break;
                case 2:
                    alloc = "Nurse";
                    break;
                case 3:
                    alloc = "Nurse Practitioner";
                    break;
                default:
                    alloc = "Unavailable";
                    break;
            }
            if (alloc != null) {
                hospital_Bed -= 1;
                bedNum = (max - this.hospital_Bed);
                x.setBedNum(bedNum);
                x.setMedicalStaff(alloc);
                x.setAllocStats();
            }
        }
//        return "Bed #: " + bedNum + "\n" + "Medical Staff: " + alloc + "\n";
    }
}
