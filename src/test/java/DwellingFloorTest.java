import buildings.impl.Floor;
import buildings.impl.Space;
import org.junit.jupiter.api.Test;
import buildings.*;
import static org.junit.jupiter.api.Assertions.*;
public class DwellingFloorTest {
    @Test
    void testGetTotalFlats() {
        Floor floor = new DwellingFloor(3);
        int expectedTotalFlats = 3;
        int actualTotalFlats = floor.getTotalFlats();
        assertEquals(expectedTotalFlats, actualTotalFlats);
    }

    @Test
    void testGetFlatsSquare() {
        Space[] flats = {new Flat(50.0), new Flat(75.0), new Flat(60.0)};
        Floor floor = new DwellingFloor(flats);
        double expectedFlatsSquare = 185.0;
        double actualFlatsSquare = floor.getFlatsSquare();
        assertEquals(expectedFlatsSquare, actualFlatsSquare, 0.001); // Сравниваем с погрешностью
    }

    @Test
    void testGetFlatsQuantity() {
        Space[] flats = {new Flat(50.0, 2), new Flat(75.0, 3), new Flat(60.0, 1)};
       Floor floor = new DwellingFloor(flats);
        int expectedFlatsQuantity = 6;
        int actualFlatsQuantity = floor.getFlatsQuantity();
        assertEquals(expectedFlatsQuantity, actualFlatsQuantity);
    }
    @Test
    void testGetFlats() {
        Space[] flats = {new Flat(50.0, 2), new Flat(75.0, 3), new Flat(60.0, 1)};
        Floor floor = new DwellingFloor(flats);
        Space[] expectedFlats = floor.getFlats();
        assertArrayEquals(flats, expectedFlats);
    }
    @Test
    void testGetFlatsByIndex() {
        Space[] flats = {new Flat(50.0, 2), new Flat(75.0, 3), new Flat(60.0, 1)};
        Floor floor = new DwellingFloor(flats);
        Space expectedFlat = flats[1];
        Space actualFlat = floor.getFlat(1);
        assertEquals(expectedFlat, actualFlat);
    }
    @Test
    void testSetFlat() {
        Floor floor = new DwellingFloor(3);
        Space newFlat = new Flat(80.0);
        floor.setFlat(1, newFlat);
        assertEquals(newFlat, floor.getFlat(1));
    }

    @Test
    void testAddFlat() {
        Floor floor = new DwellingFloor(3);
        Space newFlat = new Flat(80.0);
        floor.addFlat(1, newFlat);
        assertEquals(newFlat, floor.getFlat(1));
        assertEquals(4, floor.getTotalFlats());
    }

    @Test
    void testDeleteFlat() {
       Floor floor = new DwellingFloor(3);
        floor.deleteFlat(1);
        assertEquals(2, floor.getTotalFlats());
    }

    @Test
    void testGetBestSquare() {
        Space[] flats = {new Flat(50.0), new Flat(75.0), new Flat(60.0)};
       Floor floor = new DwellingFloor(flats);
        double expectedBestSquare = 75.0;
        double actualBestSquare = floor.getBestSquare();
        assertEquals(expectedBestSquare, actualBestSquare, 0.001);
    }

}