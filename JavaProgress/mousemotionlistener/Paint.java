package JavaProgress.mousemotionlistener;

import java.awt.*;

import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionListener;

public class Paint extends Frame implements MouseMotionListener {


    Label l;

    Color c = Color.BLUE;

    Paint() {

        l = new Label();

        l.setBounds(20, 40, 200, 20);

        add(l);


        addMouseMotionListener(this);


        setSize(400, 400);

        setLayout(null);

        setVisible(true);

    }

    public void mouseDragged(MouseEvent e) {

        l.setText("Dragging: X=" + e.getX() + ", Y=" + e.getY());

        Graphics g = getGraphics();

        g.setColor(Color.RED);

        g.fillOval(e.getX(), e.getY(), 20, 20);

    }

    public void mouseMoved(MouseEvent e) {

        l.setText("Moving: X=" + e.getX() + ", Y=" + e.getY());
        Graphics g = getGraphics();

        g.setColor(Color.BLUE);

        g.fillOval(e.getX(), e.getY(), 20, 20);

    }

    public static void main(String[] args) {

        new Paint();

    }

}