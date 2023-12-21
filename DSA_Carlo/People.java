package DSA_Carlo;


public class People {
    String name;
    int age;
    String medical_Condition;
    Priority priority;
    boolean alloc;
    int bedNum;
    String medStaff;
    public People(String name, int age, String medical_Condition, Priority priority) {
        this.name = name;
        this.age = age;
        this.medical_Condition = medical_Condition;
        this.priority = priority;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public String getInfo() {
        return "Name: " + this.name + " Age: " + this.age + " Condition: " +this.medical_Condition + " Priority: " + this.priority;
    }

    public boolean getAlloc() {
        return this.alloc;
    }

    public void setAlloc() {
        this.alloc = true;
    }

    public String assignedInfo() {
        return "\nBed #:" + this.bedNum + " Medical Staff: " + this.medStaff + "\n";
    }

    public void setBed(int bedNum) {
        this.bedNum = bedNum;
    }

    public void setStaff(String alloc) {
        this.medStaff = alloc;
    }

    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
}
