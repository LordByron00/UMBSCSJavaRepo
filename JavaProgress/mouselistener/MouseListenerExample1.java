package JavaProgress.mouselistener;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class MouseListenerExample1 extends Frame implements MouseListener {

    Label l;

    MouseListenerExample1() {

        addMouseListener(this);

        l = new Label();

        l.setBounds(20, 50, 100, 20);

        add(l);

        setSize(300, 300);

        setLayout(null);

        setVisible(true);


    }


    public void mouseClicked(MouseEvent e) {
        l.setText("Don't poke me!");
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setBackground(Color.BLUE);

    }

    public void mouseEntered(MouseEvent e) {
        l.setText("Welcome back!");
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setBackground(Color.WHITE);
    }

    public void mouseExited(MouseEvent e) {
        l.setText("Don't leave me!");
        setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        setBackground(Color.DARK_GRAY);
    }

    public void mousePressed(MouseEvent e) {
        l.setText("Ouch!");
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBackground(Color.GREEN);
    }

    public void mouseReleased(MouseEvent e) {
        l.setText("Mouse Released");
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setBackground(Color.RED);
    }


    public static void main(String[] args) {

        new MouseListenerExample1();

    }

}