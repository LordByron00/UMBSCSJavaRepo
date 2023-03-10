package JavaProgress.keylistener;

import java.awt.*;
import java.awt.event.*;

// class which inherits Frame class and implements KeyListener interface

public class KeyListenerExample1 extends Frame implements KeyListener {


// creating object of Label class  and TextArea class

    Label l;

    TextArea area;

    // class constructor

    KeyListenerExample1() {

        // creating the label

        l = new Label();

        // setting the location of the label in frame

        l.setBounds(150, 40, 100, 20);

        // creating the text area

        area = new TextArea();
        // setting the location of text area

        area.setBounds(50, 65, 300, 300);

        // adding the KeyListener to the text area

        area.addKeyListener(this);

        // adding the label and text area to the frame

        add(l);

        add(area);

        // setting the size, layout and visibility of frame

        setSize(400, 400);

        setLayout(null);

        setVisible(true);

    }

    // overriding the keyPressed() method of KeyListener interface where we set the text of the label when key is pressed

    public void keyPressed(KeyEvent e) {

        l.setText("Key Pressed");


    }

    // overriding the keyReleased() method of KeyListener interface where we set the text of the label when key is released

    public void keyReleased(KeyEvent e) {
        l.setForeground(Color.BLUE);
        l.setText("Key Released");

    }

    // overriding the keyTyped() method of KeyListener interface where we set the text of the label when a key is typed

    public void keyTyped(KeyEvent e) {
        l.setForeground(Color.RED);
        l.setText("Key Typed");

    }

    // main method

    public static void main(String[] args) {

        new KeyListenerExample1();

    }

}