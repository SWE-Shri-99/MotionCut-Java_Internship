import javax.swing.JFrame;

/**
 * The main class to start the Brick Breaker game.
 */
public class BrickBreakerGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Brick Breaker");
        GamePanel gamePanel = new GamePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.add(gamePanel);
        frame.setVisible(true);
    }
}