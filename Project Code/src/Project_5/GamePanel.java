import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The GamePanel class is responsible for handling the game's graphical interface,
 * user input, and main game loop.
 */
public class GamePanel extends JPanel implements KeyListener {
    private Paddle paddle;
    private Ball ball;
    private ArrayList<Brick> bricks;
    private Timer timer;
    private boolean isPaused = false;
    private Sound hitSound;
    private Sound breakSound;
    private Sound gameOverSound;

    /**
     * Constructs the GamePanel, initializes game objects, and starts the game loop.
     */
    public GamePanel() {
        paddle = new Paddle(375, 550, 100, 10);
        ball = new Ball(400, 300, 10);
        bricks = new ArrayList<>();

        // Initialize bricks (example)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                bricks.add(new Brick(80 * j, 30 * i, 75, 25, Color.GREEN));
            }
        }

        // Load sounds
        hitSound = new Sound("/Project_5/sounds/hit.wav");
        breakSound = new Sound("/Project_5/sounds/break.wav");
        gameOverSound = new Sound("Project_5/sounds/gameover.wav");

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(10, e -> gameLoop());
        timer.start();
    }

    /**
     * The main game loop.
     */
    private void gameLoop() {
        if (!isPaused) {
            ball.move();
            checkCollisions();
            checkGameOver();
            checkVictory();
            repaint();
        }
    }

    /**
     * Paints the game components.
     *
     * @param g the Graphics object used for drawing
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();
        drawPaddle(g2d);
        drawBall(g2d);
        drawBricks(g2d);
        g.drawImage(buffer, 0, 0, this);
    }

    private void drawPaddle(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
    }

    private void drawBall(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
    }

    private void drawBricks(Graphics g) {
        for (Brick brick : bricks) {
            if (!brick.isBroken()) {
                g.setColor(brick.getColor());
                g.fillRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
            }
        }
    }

    /**
     * Handles key pressed events for paddle control and game pause/resume.
     *
     * @param e the KeyEvent object containing details about the key pressed event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.move(-10);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.move(10);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isPaused = !isPaused;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    private void checkCollisions() {
        // Check collision with paddle
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.setYDirection(-ball.getYDirection());
            hitSound.play(); // Play hit sound when ball hits the paddle
        }

        // Check collision with bricks
        for (Brick brick : bricks) {
            if (!brick.isBroken() && ball.getBounds().intersects(brick.getBounds())) {
                ball.setYDirection(-ball.getYDirection());
                brick.setBroken(true);
                breakSound.play(); // Play break sound when ball hits a brick
                // Update score (implement scoring logic)
            }
        }
    }

    private void checkGameOver() {
        if (ball.getY() > getHeight()) {
            timer.stop();
            gameOverSound.play(); // Play game over sound
            JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    private void checkVictory() {
        boolean allBricksBroken = true;
        for (Brick brick : bricks) {
            if (!brick.isBroken()) {
                allBricksBroken = false;
                break;
            }
        }
        if (allBricksBroken) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "You Win!", "Victory", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}