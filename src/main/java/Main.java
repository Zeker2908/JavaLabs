import buildings.*;
import buildings.impl.Space;

public class Main {
    public static void main(String[] args) {
        int[] flatsPerFloor = {3, 4, 2}; // Количество квартир на каждом этаже
        double[][] flatData = {
                {60.5, 2},
                {75.0, 3},
                {48.8, 1},
                {85.2, 2},
                {70.0, 2},
                {100.1, 4},
                {92.5, 3},
                {55.3, 2}
        };

        DwellingFloor[] floors = new DwellingFloor[flatsPerFloor.length];
        for (int i = 0; i < flatsPerFloor.length; i++) {
            int flatsCount = flatsPerFloor[i];
            Flat[] flats = new Flat[flatsCount];
            for (int j = 0; j < flatsCount; j++) {
                double square = flatData[i * flatsPerFloor.length + j][0];
                int rooms = (int) flatData[i * flatsPerFloor.length + j][1];
                flats[j] = new Flat(square, rooms);
            }
            floors[i] = new DwellingFloor(flats);
        }

        Dwelling dwelling = new Dwelling(floors);

        // Вызов методов класса Dwelling
        System.out.println("Общее количество этажей в доме: " + dwelling.getFloorsQuantity());
        System.out.println("Общее количество квартир в доме: " + dwelling.getFlatsQuantity());
        System.out.println("Общая площадь квартир в доме: " + dwelling.getFlatsSquare());
        System.out.println("Общее количество комнат в доме: " + dwelling.getTotalFlats());

        System.out.println("\nИнформация о каждом этаже:");
        for (int i = 0; i < floors.length; i++) {
            System.out.println("Этаж " + (i + 1) + ":");
            DwellingFloor floor = floors[i];
            Space[] floorFlats = floor.getFlats();
            for (int j = 0; j < floorFlats.length; j++) {
                System.out.println("   Квартира " + (j + 1) + ": " + floorFlats[j].getSquare() + " кв. м, " + floorFlats[j].getQuantity() + " комн.");
            }
        }

        Space bestFlat = dwelling.getBestSpaceBySquare();
        if (bestFlat != null) {
            System.out.println("\nСамая большая по площади квартира:");
            System.out.println("Площадь: " + bestFlat.getSquare() + " кв. м, Количество комнат: " + bestFlat.getQuantity());
        } else {
            System.out.println("\nВ доме нет квартир.");
        }

        Space[] sortedFlats = dwelling.getSortSpacesBySquare(-1);
        System.out.println("\nКвартиры в порядке убывания площади:");
        for (int i = 0; i < sortedFlats.length; i++) {
            System.out.println("Квартира " + (i + 1) + ": " + sortedFlats[i].getSquare() + " кв. м");
        }

        floors[1].deleteFlat(1);
        System.out.println("\nИнформация после удаления квартиры:");
        System.out.println("Общее количество квартир в доме: " + dwelling.getFlatsQuantity());
    }
}
