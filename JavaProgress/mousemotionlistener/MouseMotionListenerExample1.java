package JavaProgress.mousemotionlistener;

import java.awt.*;

import java.awt.event.*;

public class MouseMotionListenerExample1 extends Frame implements MouseMotionListener {


    MouseMotionListenerExample1() {

        addMouseMotionListener(this);


        setSize(300, 300);

        setLayout(null);

        setVisible(true);

    }

    public void mouseDragged(MouseEvent e) {

        Graphics g = getGraphics();

        g.setColor(Color.BLUE);

        g.fillOval(e.getX(), e.getY(), 10, 10);

    }

    public void mouseMoved(MouseEvent e) {
        Graphics g = getGraphics();

        g.setColor(Color.WHITE);

        g.fillOval(e.getX(), e.getY(), 20, 20);
    }


    public static void main(String[] args) {

        new MouseMotionListenerExample1();

    }

}

