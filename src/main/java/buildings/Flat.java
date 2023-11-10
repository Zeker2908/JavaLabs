package buildings;

import buildings.impl.AbstractSpace;
import buildings.impl.Space;
import lombok.Data;

@Data
public class Flat extends AbstractSpace implements Space {
    final double DEF_SQUARE = 50;
    final int DEF_QUANTITY = 2;

    public Flat() {
        super();
    }

    public Flat(double square) {
        super(square);
    }

    public Flat(double square, int quantity) {
        super(square, quantity);
    }

    @Override
    protected double getDefaultSquare() {
        return DEF_SQUARE;
    }

    @Override
    protected int getDefaultQuantity() {
        return DEF_QUANTITY;
    }
}
