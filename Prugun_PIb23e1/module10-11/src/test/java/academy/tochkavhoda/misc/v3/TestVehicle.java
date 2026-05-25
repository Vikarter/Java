package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.figures.v3.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVehicle {

    @Test
    public void testVehicleWithColor() throws ColorException {
        Vehicle vehicle = new Vehicle("BMW", Color.RED, 10, 20);
        assertAll(
                () -> assertEquals("BMW", vehicle.getName()),
                () -> assertEquals(Color.RED, vehicle.getColor()),
                () -> assertEquals(10, vehicle.getPosition().getX()),
                () -> assertEquals(20, vehicle.getPosition().getY())
        );
    }

    @Test
    public void testVehicleWithString() throws ColorException {
        Vehicle vehicle = new Vehicle("BMW", "GREEN", 0, 0);
        assertEquals(Color.GREEN, vehicle.getColor());
    }

    @Test
    public void testVehicleDefault() {
        Vehicle vehicle = new Vehicle();
        assertAll(
                () -> assertEquals("Vehicle", vehicle.getName()),
                () -> assertEquals(Color.RED, vehicle.getColor()),
                () -> assertEquals(0, vehicle.getPosition().getX()),
                () -> assertEquals(0, vehicle.getPosition().getY())
        );
    }

    @Test
    public void testVehicleMove() throws ColorException {
        Vehicle vehicle = new Vehicle("BMW", Color.RED);
        vehicle.moveTo(10, 20);
        assertEquals(10, vehicle.getPosition().getX());
        assertEquals(20, vehicle.getPosition().getY());

        vehicle.moveRel(5, 5);
        assertEquals(15, vehicle.getPosition().getX());
        assertEquals(25, vehicle.getPosition().getY());

        vehicle.moveTo(new Point(100, 200));
        assertEquals(100, vehicle.getPosition().getX());
        assertEquals(200, vehicle.getPosition().getY());
    }

    @Test
    public void testSetColor() throws ColorException {
        Vehicle vehicle = new Vehicle("BMW", Color.RED);
        vehicle.setColor(Color.BLUE);
        assertEquals(Color.BLUE, vehicle.getColor());

        vehicle.setColor("GREEN");
        assertEquals(Color.GREEN, vehicle.getColor());
    }

    @Test
    public void testNullColorThrows() throws ColorException {
        Vehicle vehicle = new Vehicle("BMW", Color.RED);
        assertThrows(ColorException.class, () -> vehicle.setColor((Color) null));
        assertThrows(ColorException.class, () -> vehicle.setColor((String) null));
        assertThrows(ColorException.class, () -> new Vehicle("BMW", (Color) null));
    }

    @Test
    public void testWrongColorStringThrows() {
        assertThrows(ColorException.class, () -> new Vehicle("BMW", "YELLOW"));
    }

    @Test
    public void testVehicleEquals() throws ColorException {
        Vehicle vehicle1 = new Vehicle("BMW", Color.RED, 0, 0);
        Vehicle vehicle2 = new Vehicle("BMW", Color.RED, 0, 0);
        Vehicle vehicle3 = new Vehicle("Audi", Color.RED, 0, 0);
        Vehicle vehicle4 = new Vehicle("BMW", Color.BLUE, 0, 0);
        assertEquals(vehicle1, vehicle2);
        assertNotEquals(vehicle1, vehicle3);
        assertNotEquals(vehicle1, vehicle4);
    }
}