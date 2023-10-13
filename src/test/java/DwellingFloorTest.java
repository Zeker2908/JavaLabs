import org.junit.jupiter.api.Test;
import buildings.*;
import static org.junit.jupiter.api.Assertions.*;

public class DwellingFloorTest {
    @Test
    void testGetTotalFlats() {
        DwellingFloor floor = new DwellingFloor(3);
        int expectedTotalFlats = 3;
        int actualTotalFlats = floor.getTotalFlats();
        assertEquals(expectedTotalFlats, actualTotalFlats);
    }

    @Test
    void testGetFlatsSquare() {
        Flat[] flats = {new Flat(50.0), new Flat(75.0), new Flat(60.0)};
        DwellingFloor floor = new DwellingFloor(flats);
        double expectedFlatsSquare = 185.0; // 50.0 + 75.0 + 60.0
        double actualFlatsSquare = floor.getFlatsSquare();
        assertEquals(expectedFlatsSquare, actualFlatsSquare, 0.001); // Сравниваем с погрешностью
    }

    @Test
    void testGetFlatsQuantity() {
        Flat[] flats = {new Flat(50.0, 2), new Flat(75.0, 3), new Flat(60.0, 1)};
        DwellingFloor floor = new DwellingFloor(flats);
        int expectedFlatsQuantity = 6; // 2 + 3 + 1
        int actualFlatsQuantity = floor.getFlatsQuantity();
        assertEquals(expectedFlatsQuantity, actualFlatsQuantity);
    }
    @Test
    void testGetFlats() {
        Flat[] flats = {new Flat(50.0, 2), new Flat(75.0, 3), new Flat(60.0, 1)};
        DwellingFloor floor = new DwellingFloor(flats);
        Flat[] expectedFlats = floor.getFlats();
        assertArrayEquals(flats, expectedFlats);
    }
    @Test
    void testGetFlatsByIndex() {
        Flat[] flats = {new Flat(50.0, 2), new Flat(75.0, 3), new Flat(60.0, 1)};
        DwellingFloor floor = new DwellingFloor(flats);
        Flat expectedFlat = flats[1];
        Flat actualFlat = floor.getFlats(1);
        assertEquals(expectedFlat, actualFlat);
    }
    @Test
    void testSetFlat() {
        DwellingFloor floor = new DwellingFloor(3);
        Flat newFlat = new Flat(80.0);
        floor.setFlat(1, newFlat);
        assertEquals(newFlat, floor.getFlats(1));
    }

    @Test
    void testAddFlat() {
        DwellingFloor floor = new DwellingFloor(3);
        Flat newFlat = new Flat(80.0);
        floor.addFlat(1, newFlat);
        assertEquals(newFlat, floor.getFlats(1));
        assertEquals(4, floor.getTotalFlats());
    }

    @Test
    void testDeleteFlat() {
        DwellingFloor floor = new DwellingFloor(3);
        floor.deleteFlat(1);
        assertEquals(2, floor.getTotalFlats());
    }

    @Test
    void testGetBestSquare() {
        Flat[] flats = {new Flat(50.0), new Flat(75.0), new Flat(60.0)};
        DwellingFloor floor = new DwellingFloor(flats);
        double expectedBestSquare = 75.0;
        double actualBestSquare = floor.getBestSquare();
        assertEquals(expectedBestSquare, actualBestSquare, 0.001);
    }

}