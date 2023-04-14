package JavaProgress.KeyLogger;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;

public class KeyLogger extends JFrame implements KeyListener {
    public KeyLogger() {
        addKeyListener(this);
    }

    public void keyTyped(KeyEvent e) {
        try {
            FileWriter writer = new FileWriter("output.txt", true);
            writer.write(e.getKeyChar());
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        KeyLogger keyLogger = new KeyLogger();
        keyLogger.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        keyLogger.setSize(400, 400);
        keyLogger.setVisible(true);
    }
}

// Fuck you, Auirea!
//I no nanaaman system.out
//Ulol First time ko may kasama dito ah. Masaya pala sa pakiramdam. Feeling ko bubuhatin mo ako sa pag-cocode. Angas
//Ikaw na gumawa ng projects ko. Thank you
// aba ano ka sinuswerte?
//Oo naman, swerte talaga ako.
//try mo nga magchat sa call
//

