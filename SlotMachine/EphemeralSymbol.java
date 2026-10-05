
/**
 * Write a description of class EmpheralSymbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EphemeralSymbol extends Symbol {
    private int height;
    private int width;

    /**
     * Default constructor.
     */
    public EphemeralSymbol() {
        super();
        this.height = 30;
        this.width = 40;
    }

    /**
     * Creates an ephemeral symbol with a specific color.
     *
     * @param color the color of the symbol.
     */
    public EphemeralSymbol(String color) {
        super(color);
        this.height = 30;
        this.width = 40;
    }

    /**
     * Decreases the size of the symbol when selected.
     */
    @Override
    public void selected() {
        if (height > 2) {
            height = height - 1;
        }

        if (width > 2) {
            width = width - 1;
        }

        if (height < 2) {
            height = 2;
        }

        if (width < 2) {
            width = 2;
        }

        changeSize(height, width);
    }

    /**
     * Returns the current height.
     *
     * @return the current height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the current width.
     *
     * @return the current width.
     */
    public int getWidth() {
        return width;
    }
}
