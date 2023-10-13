package buildings;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class Dwelling {
    private DwellingFloor[] floors;


    public Dwelling(int numberOfFloors, int[] flatsPerFloor) {
        floors = new DwellingFloor[numberOfFloors];
        for (int i = 0; i < numberOfFloors; i++) {
            floors[i] = new DwellingFloor(flatsPerFloor[i]);
        }
    }

    public Dwelling(DwellingFloor[] floors) {
        this.floors = floors;
    }


    public int getDwellingFloorQuantity() {
        return floors.length;
    }

    public int getFlatsQuantity() {
        int totalFlats = 0;
        for (DwellingFloor floor : floors) {
            totalFlats += floor.getTotalFlats();
        }
        return totalFlats;
    }

    public double getFlatsSquare() {
        double totalSquare = 0.0;
        for (DwellingFloor floor : floors) {
            totalSquare += floor.getFlatsSquare();
        }
        return totalSquare;
    }


    public int getRoomsQuantity() {
        int totalRooms = 0;
        for (DwellingFloor floor : floors) {
            totalRooms += floor.getFlatsQuantity();
        }
        return totalRooms;
    }


    public DwellingFloor[] getDwellingFloors() {
        return floors;
    }

    // Метод для получения объекта этажа по его номеру в доме
    public DwellingFloor getDwellingFloor(int index) {
        if (index >= 0 && index < floors.length) {
            return floors[index];
        } else {
            return null;
        }
    }

    public void setDwellingFloor(int index, DwellingFloor newDwellingFloor) {
        if (index >= 0 && index < floors.length) {
            floors[index] = newDwellingFloor;
        }
    }

    public Flat getFlat(int index) {
        for (DwellingFloor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                return floor.getFlats(index);
            } else {
                index -= floor.getTotalFlats();
            }
        }
        return null;
    }


    public void setFlat(int index, Flat newFlat) {
        for (DwellingFloor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                floor.setFlat(index, newFlat);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }


    public void addFlat(int index, Flat newFlat) {
        for (DwellingFloor floor : floors) {
            if (index >= 0 && index <= floor.getTotalFlats()) {
                floor.addFlat(index, newFlat);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }

    public void deleteFlat(int index) {
        for (DwellingFloor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                floor.deleteFlat(index);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }


    public Flat getBestFlatBySquare() {
        Flat bestFlat = null;
        double maxSquare = 0.0;

        for (DwellingFloor floor : floors) {
            if (floor.getTotalFlats() > 0) {
                Flat[] flats = floor.getFlats();
                for (Flat flat : flats) {
                    double square = flat.getSquare();
                    if (square > maxSquare) {
                        maxSquare = square;
                        bestFlat = flat;
                    }
                }
            }
        }

        return bestFlat;
    }




    public Flat[] getSortFlatsBySquare(int order) {
        if((order==-1)|(order==1)) {
            List<Flat> allFlats = new ArrayList<>();
            for (DwellingFloor floor : floors) {
                for (int i = 0; i < floor.getTotalFlats(); i++) {
                    allFlats.add(floor.getFlats(i));
                }
            }


            allFlats.sort((flat1, flat2) -> Double.compare(flat1.getSquare(), flat2.getSquare()) * order);

            return allFlats.toArray(new Flat[0]);
        }
        else {
            if(order>0) {
                return this.getSortFlatsBySquare(1);
            }
            else {
                return this.getSortFlatsBySquare(-1);
            }
        }
    }
}
