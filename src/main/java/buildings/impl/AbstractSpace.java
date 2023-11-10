package buildings.impl;

public abstract class AbstractSpace {
    final double DEF_SQUARE=50;
    final int DEF_QUANTITY=2;
    private double square;
    private int quantity;

    public AbstractSpace() {
        this.square = DEF_SQUARE;
        this.quantity = DEF_QUANTITY;
    }

    public AbstractSpace(double square) {
        this.square = square;
        this.quantity = DEF_QUANTITY;
    }

    public AbstractSpace(double square, int quantity) {
        this.square = square;
        this.quantity = quantity;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    protected abstract double getDefaultSquare();

    protected abstract int getDefaultQuantity();
}

