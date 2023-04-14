package FinalProject;

import java.io.Serializable;

public class User implements Serializable {
	private String password, username;
	public User(String user, String pass) {
		this.username = user;
		this.password = pass;
	}
	
	public String getUser() {
		return username;
	}
	
	public String getPass() {
		return password;
	}
}
