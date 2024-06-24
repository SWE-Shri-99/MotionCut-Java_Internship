import java.awt.Color;
import java.awt.Rectangle;

/**
 * The Brick class represents a brick in the Brick Breaker game.
 */
public class Brick {
    private int x, y, width, height;
    private Color color;
    private boolean isBroken;

    /**
     * Constructs a new Brick with specified position, size, and color.
     *
     * @param x      the x-coordinate of the brick
     * @param y      the y-coordinate of the brick
     * @param width  the width of the brick
     * @param height the height of the brick
     * @param color  the color of the brick
     */
    public Brick(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isBroken = false;
    }

    // Getters and setters for brick properties
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

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    /**
     * Gets the bounds of the brick for collision detection.
     *
     * @return a Rectangle representing the bounds of the brick
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}