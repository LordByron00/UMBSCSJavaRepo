import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGame extends JPanel implements KeyListener {

    private int x, y; // coordinates of the snake
    private int foodX, foodY; // coordinates of the food
    private boolean right = true, left = false, up = false, down = false; // snake direction

    public SnakeGame() {
        addKeyListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500); // drawing the game board
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 10, 10); // drawing the snake
        g.setColor(Color.RED);
        g.fillRect(foodX, foodY, 10, 10); // drawing the food
    }

    public void move() {
        if (right) {
            x++;
        }
        if (left) {
            x--;
        }
        if (up) {
            y--;
        }
        if (down) {
            y++;
        }
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_RIGHT && !left) {
            right = true;
            up = false;
            down = false;
        }
        if (code == KeyEvent.VK_LEFT && !right) {
            left = true;
            up = false;
            down = false;
        }
        if (code == KeyEvent.VK_UP && !down) {
            up = true;
            left = false;
            right = false;
        }
        if (code == KeyEvent.VK_DOWN && !up) {
            down = true;
            left = false;
            right = false;
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(100);
        }
    }
}
