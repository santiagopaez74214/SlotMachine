
/**
 * Write a description of class Shape here.
 * 
 * @author David Páez y Joseph Cañon
 * @version 18/09/2026
 */
public abstract class  Shape{
    protected int height;
    protected int width;
    protected int xPosition;
    protected int yPosition;
    protected String color;
    protected boolean isVisible;

    public Shape(int height, int width, int xPosition, int yPosition, String color) {
        this.height = height;
        this.width = width;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
        this.isVisible = false;
    }

    public abstract void draw();
    
    public abstract void erase();

    public void makeVisible() {
        isVisible = true;
        draw();
    }

    public void makeInvisible() {
        erase();
        isVisible = false;
    }

    public void moveRight() {
        moveHorizontal(20);
    }

    public void moveLeft() {
        moveHorizontal(-20);
    }

    public void moveUp() {
        moveVertical(-20);
    }

    public void moveDown() {
        moveVertical(20);
    }

    public void moveHorizontal(int distance) {
        erase();
        xPosition += distance;
        draw();
    }

    public void moveVertical(int distance) {
        erase();
        yPosition += distance;
        draw();
    }

    public void slowMoveHorizontal(int distance) {
        int delta = (distance < 0) ? -1 : 1;
        int steps = Math.abs(distance);

        for (int i = 0; i < steps; i++) {
            xPosition += delta;
            draw();
        }
    }

    public void slowMoveVertical(int distance) {
        int delta = (distance < 0) ? -1 : 1;
        int steps = Math.abs(distance);

        for (int i = 0; i < steps; i++) {
            yPosition += delta;
            draw();
        }
    }

    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }

    public void changeColor(String newColor) {
        color = newColor;
        draw();
    }

    public void changePosition(int x, int y) {
        erase();
        this.xPosition = x;
        this.yPosition = y;
        draw();
    }
}
