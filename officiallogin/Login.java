package officiallogin;

import javax.swing.JFrame;

public class Login {
    public static void main(String[] a) {
        OfficialLogIn frame = new OfficialLogIn();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(600, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);


    }

}