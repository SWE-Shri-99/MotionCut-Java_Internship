import java.awt.Rectangle;

/**
 * The Ball class represents the ball in the Brick Breaker game.
 */
public class Ball {
    private int x, y, diameter;
    private int xDirection, yDirection;

    /**
     * Constructs a new Ball with specified position and diameter.
     *
     * @param x        the x-coordinate of the ball
     * @param y        the y-coordinate of the ball
     * @param diameter the diameter of the ball
     */
    public Ball(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.xDirection = -1;
        this.yDirection = -1;
    }

    /**
     * Moves the ball according to its direction.
     */
    public void move() {
        x += xDirection;
        y += yDirection;

        if (x <= 0 || x >= 800 - diameter) {
            xDirection = -xDirection;
        }

        if (y <= 0) {
            yDirection = -yDirection;
        }
    }

    // Getters for ball properties
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    /**
     * Gets the current Y direction of the ball.
     *
     * @return the Y direction of the ball
     */
    public int getYDirection() {
        return yDirection;
    }

    /**
     * Gets the bounds of the ball for collision detection.
     *
     * @return a Rectangle representing the bounds of the ball
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }

    /**
     * Sets the Y direction of the ball.
     *
     * @param yDirection the new Y direction
     */
    public void setYDirection(int yDirection) {
        this.yDirection = yDirection;
    }
}