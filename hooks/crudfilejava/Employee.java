// JAVA CRUD Menu Options with Array List Implementation and File Handling
//        Source: https://www.youtube.com/watch?v=EfS6i_jAm4g

//CLASS EMPLOYEE
package hooks.crudfilejava;

import java.io.Serializable;

public class Employee implements Serializable {
    int empno;
    String ename;
    int salary;

    Employee(int empno, String ename, int salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }

    public String toString() {
        return empno + " " + ename + " " + salary;
    }
}

