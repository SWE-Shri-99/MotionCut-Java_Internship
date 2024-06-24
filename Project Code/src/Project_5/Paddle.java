import java.awt.Rectangle;
import java.awt.Color;

/**
 * The Paddle class represents the player's paddle in the Brick Breaker game.
 */
public class Paddle {
    private int x, y, width, height;
    private Color color;

    /**
     * Constructs a new Paddle with the specified position, size, and color.
     *
     * @param x      the x-coordinate of the paddle
     * @param y      the y-coordinate of the paddle
     * @param width  the width of the paddle
     * @param height the height of the paddle
     */
    public Paddle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.BLUE;
    }

    /**
     * Moves the paddle horizontally by the specified amount.
     *
     * @param deltaX the amount to move the paddle horizontally
     */
    public void move(int deltaX) {
        x += deltaX;
        // Limit paddle movement within the game window
        if (x < 0) {
            x = 0;
        } else if (x > 800 - width) {
            x = 800 - width;
        }
    }

    // Getters for paddle properties
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    /**
     * Gets the bounds of the paddle for collision detection.
     *
     * @return a Rectangle representing the bounds of the paddle
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}