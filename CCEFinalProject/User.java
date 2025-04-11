package CCEFinalProject;

import java.io.Serializable;

public class User implements Serializable {
    private String name, surname, username, email, address;
    private char[] password;
    private int number;

    public User(String name, String surname, String user, char[] pass, String email, int number, String address) {
        this.name = name;
        this.surname = surname;
        this.username = user;
        this.password = pass;
        this.email = email;
        this.number = number;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getfullName() {
        return name + " " + surname;
    }

    public String getUser() {
        return username;
    }

    public char[] getPass() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getNum() {
        return number;
    }

    public String getAdd() {
        return address;
    }
}
