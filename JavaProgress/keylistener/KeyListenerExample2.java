package JavaProgress.keylistener;

import java.awt.*;

import java.awt.event.*;


public class KeyListenerExample2 extends Frame implements KeyListener {

    Label l, b, c;

    TextArea area;


    KeyListenerExample2() {
        c = new Label();
        b = new Label();
        l = new Label();

        l.setBounds(20, 50, 150, 20);
        b.setBounds(200, 50, 200, 20);
        c.setBounds(150, 30, 150, 20);

        area = new TextArea();


        area.setBounds(20, 80, 300, 300);


        area.addKeyListener(this);

        add(c);
        add(l);
        add(b);
        add(area);

        setSize(400, 400);
        setLayout(null);

        setVisible(true);

    }

// even if we do not define the interface methods, we need to override them

    public void keyPressed(KeyEvent e) {
    }

// overriding the keyReleased() method of KeyListener interface

    public void keyReleased(KeyEvent e) {

// defining a string which is fetched by the getText() method of TextArea class

        String text = area.getText();

// splitting the string in words

        String words[] = text.split("\\s");

// printing the number of words and characters of the string
        for (int i = 0; i < words.length; i++) {
            b.setText("Word: " + words[i]);
        }
        l.setText("Words: " + words.length + " Characters:" + text.length());

    }

    public void keyTyped(KeyEvent e) {
        String text = area.getText();
        for (int i = 0; i < text.length(); i++) {
            c.setText("Character: " + text.charAt(i));
        }
    }

    // main method

    public static void main(String[] args) {

        new KeyListenerExample2();

    }

}