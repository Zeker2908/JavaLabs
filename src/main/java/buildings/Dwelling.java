package buildings;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


public class Dwelling {
    private DwellingFloor[] floors;

    // Конструктор 1, принимающий количество этажей и массив количества квартир по этажам
    public Dwelling(int numberOfFloors, int[] flatsPerFloor) {
        floors = new DwellingFloor[numberOfFloors];
        for (int i = 0; i < numberOfFloors; i++) {
            floors[i] = new DwellingFloor(flatsPerFloor[i]);
        }
    }

    // Конструктор 2, принимающий массив этажей дома
    public Dwelling(DwellingFloor[] floors) {
        this.floors = floors;
    }

    // Метод для получения общего количества этажей дома
    public int getDwellingFloorQuantity() {
        return floors.length;
    }

    // Метод для получения общего количества квартир дома
    public int getFlatsQuantity() {
        int totalFlats = 0;
        for (DwellingFloor floor : floors) {
            totalFlats += floor.getTotalFlats();
        }
        return totalFlats;
    }

    // Метод для получения общей площади квартир дома
    public double getFlatsSquare() {
        double totalSquare = 0.0;
        for (DwellingFloor floor : floors) {
            totalSquare += floor.getFlatsSquare();
        }
        return totalSquare;
    }

    // Метод для получения общего количества комнат дома
    public int getRoomsQuantity() {
        int totalRooms = 0;
        for (DwellingFloor floor : floors) {
            totalRooms += floor.getFlatsQuantity();
        }
        return totalRooms;
    }

    // Метод для получения массива этажей жилого дома
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

    // Метод для изменения этажа по его номеру в доме
    public void setDwellingFloor(int index, DwellingFloor newDwellingFloor) {
        if (index >= 0 && index < floors.length) {
            floors[index] = newDwellingFloor;
        }
    }

    // Метод для получения объекта квартиры по ее номеру в доме
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

    // Метод для изменения объекта квартиры по ее номеру в доме
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

    // Метод для добавления квартиры в дом по будущему номеру квартиры в доме
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

    // Метод для удаления квартиры по ее номеру в доме
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

    // Метод для получения самой большой по площади квартиры дома
    public Flat getBestFlatBySquare() {
        Flat bestFlat = null;
        double maxSquare = 0.0;

        for (DwellingFloor floor : floors) {
            if (floor.getTotalFlats() > 0) { // Проверяем, есть ли квартиры на этаже
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



    // Метод для получения массива квартир по убыванию/увеличению площади
    public Flat[] getSortFlatsBySquare(int order) {
        // Создаем список всех квартир дома
            List<Flat> allFlats = new ArrayList<>();
            for (DwellingFloor floor : floors) {
                for (int i = 0; i < floor.getTotalFlats(); i++) {
                    allFlats.add(floor.getFlats(i));
                }
            }

            // Сортируем квартиры по площади

            allFlats.sort((flat1, flat2) -> Double.compare(flat1.getSquare(), flat2.getSquare()) * order);

            // Преобразуем список в массив и возвращаем
            return allFlats.toArray(new Flat[0]);
    }
}
