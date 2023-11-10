package buildings;
import java.util.List;
import java.util.ArrayList;

public class OfficeDwelling implements Building {
    private Floor[] floors;

    public OfficeDwelling(int numberOfFloors, int[] flatsPerFloor) {
        floors = new DwellingFloor[numberOfFloors];
        for (int i = 0; i < numberOfFloors; i++) {
            floors[i] = new DwellingFloor(flatsPerFloor[i]);
        }
    }

    public OfficeDwelling(DwellingFloor[] floors) {
        this.floors = floors;
    }

    public int getFloorsQuantity() {
        return floors.length;
    }

    public int getFlatsQuantity() {
        int totalFlats = 0;
        for (Floor floor : floors) {
            totalFlats += floor.getTotalFlats();
        }
        return totalFlats;
    }

    public double getFlatsSquare() {
        double totalSquare = 0.0;
        for (Floor floor : floors) {
            totalSquare += floor.getFlatsSquare();
        }
        return totalSquare;
    }


    public int getTotalFlats() {
        int totalRooms = 0;
        for (Floor floor : floors) {
            totalRooms += floor.getFlatsQuantity();
        }
        return totalRooms;
    }


    public Floor[] getFloors() {
        return floors;
    }

    public Floor getFloor(int index) {
        if (index >= 0 && index < floors.length) {
            return floors[index];
        } else {
            return null;
        }
    }

    public void setFloor(int index, Floor newFloor) {
        if (index >= 0 && index < floors.length) {
            floors[index] = newFloor;
        }
    }

    public Space getFlat(int index) {
        for (Floor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                return floor.getFlat(index);
            } else {
                index -= floor.getTotalFlats();
            }
        }
        return null;
    }


    public void setFlat(int index, Space newSpace) {
        for (Floor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                floor.setFlat(index, newSpace);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }


    public void addFlat(int index, Space newSpace) {
        for (Floor floor : floors) {
            if (index >= 0 && index <= floor.getTotalFlats()) {
                floor.addFlat(index, newSpace);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }

    public void deleteFlat(int index) {
        for (Floor floor : floors) {
            if (index >= 0 && index < floor.getTotalFlats()) {
                floor.deleteFlat(index);
                return;
            } else {
                index -= floor.getTotalFlats();
            }
        }
    }

    public Space getBestSpaceBySquare() {
        Space bestFlat = null;
        double maxSquare = 0.0;

        for (Floor floor : floors) {
            if (floor.getTotalFlats() > 0) {
                Space[] flats = floor.getFlats();
                for (Space flat : flats) {
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

    public  Space[] getSortSpacesBySquare(int order) {
        List<Space> allFlats = new ArrayList<>();
        for (Floor floor : floors) {
            for (int i = 0; i < floor.getTotalFlats(); i++) {
                allFlats.add(floor.getFlat(i));
            }
        }
        allFlats.sort((flat1, flat2) -> Double.compare(flat1.getSquare(), flat2.getSquare()) *  (int) Math.signum(order));
        return allFlats.toArray(new Space[0]);
    }
}
