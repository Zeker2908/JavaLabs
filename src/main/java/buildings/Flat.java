package buildings;
public class Flat {
    final double DEF_SQUARE=50;
    final int DEF_QUANTITY=2;
    private double square;
    private int quantity;

    public Flat(){
        this.square=DEF_SQUARE;
        this.quantity=DEF_QUANTITY;
    }
    public Flat(double square){
        this.square=square;
        this.quantity=DEF_QUANTITY;
    }
    public Flat(double square, int quantity){
        this.square=square;
        this.quantity=quantity;
    }
    public double getSquare(){
        return this.square;
    }
    public void setSquare(double newSquare){
        square=newSquare;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int newQuantity){
        quantity=newQuantity;
    }
}
