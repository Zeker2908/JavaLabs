package buildings;

public class Flat {
    private double square;
    private int quantity;

    public Flat(){
        this.square=50;
        this.quantity=2;
    }
    public Flat(double square){
        this.square=square;
        this.quantity=2;
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
