package buildings;

public class DwellingFloor {
    private Flat[] flats;

    public DwellingFloor(int countFlats) {
        flats = new Flat[countFlats];
        for (int i=0; i<countFlats; i++){
            flats[i]=new Flat();
        }
    }
    public DwellingFloor(Flat[] flats){
        this.flats=flats;
    }

    public int getTotalFlats(){
        return flats.length;
    }
    public double getFlatsSquare(){
        double sumSquare=0;
        for (int i=0; i<flats.length; i++){
            sumSquare+=flats[i].getSquare();
        }
        return sumSquare;
    }
    public int getFlatsQuantity(){
        int countQuantity=0;
        for (int i=0; i<flats.length; i++){
            countQuantity+=flats[i].getQuantity();
        }
        return countQuantity;
    }
    public Flat[] getFlats(){
        return flats;
    }
    public Flat getFlats(int index){
        return flats[index];
    }
    public void setFlat(int index, Flat newFlat){
        if (index >= 0 && index < flats.length){
            flats[index]=newFlat;
        }
        else {
            System.out.println("Неверный номер квартиры");
        }
    }
    public void addFlat(int index, Flat newFlat){
        if (index >= 0 && index <= flats.length) {
            Flat[] newFlats = new Flat[flats.length + 1];
            for (int i = 0; i < index; i++) {
                newFlats[i] = flats[i];
            }
            newFlats[index] = newFlat;
            for (int i = index; i < flats.length; i++) {
                newFlats[i + 1] = flats[i];
            }
            flats = newFlats;
        }
        else {
            System.out.println("Неверный номер квартиры");
        }
    }
    public void deleteFlat(int index) {
        if (index >= 0 && index < flats.length) {
            Flat[] newFlats = new Flat[flats.length - 1];
            for (int i = 0; i < index; i++) {
                newFlats[i] = flats[i];
            }
            for (int i = index + 1; i < flats.length; i++) {
                newFlats[i - 1] = flats[i];
            }
            flats = newFlats;
        }
        else {
            System.out.println("Неверный номер квартиры");
        }
    }
    public double getBestSquare() {
        if (flats.length == 0) {
            return 0.0;
        }
        double maxSquare = flats[0].getSquare();
        for (int i = 0; i < flats.length; i++) {
            double square = flats[i].getSquare();
            if (square > maxSquare) {
                maxSquare = square;
            }
        }
        return maxSquare;
    }
}
