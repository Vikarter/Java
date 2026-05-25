package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.figures.v2.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVehicle {

    @Test
    public void testVehicleConstructor() {
        Vehicle vehicle = new Vehicle("BMW", 2, 10, 20);
        assertAll(
                () -> assertEquals("BMW", vehicle.getName()),
                () -> assertEquals(2, vehicle.getColor()),
                () -> assertEquals(10, vehicle.getPosition().getX()),
                () -> assertEquals(20, vehicle.getPosition().getY())
        );
    }

    @Test
    public void testVehicleDefault() {
        Vehicle vehicle = new Vehicle();
        assertAll(
                () -> assertEquals("Vehicle", vehicle.getName()),
                () -> assertEquals(1, vehicle.getColor()),
                () -> assertEquals(0, vehicle.getPosition().getX()),
                () -> assertEquals(0, vehicle.getPosition().getY())
        );
    }

    @Test
    public void testVehicleMove() {
        Vehicle vehicle = new Vehicle("BMW", 1, 0, 0);
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
    public void testVehicleSetColor() {
        Vehicle vehicle = new Vehicle("BMW", 1);
        vehicle.setColor(3);
        assertEquals(3, vehicle.getColor());
    }

    @Test
    public void testVehicleSetName() {
        Vehicle vehicle = new Vehicle("BMW", 1);
        vehicle.setName("Audi");
        assertEquals("Audi", vehicle.getName());
    }

    @Test
    public void testVehicleEquals() {
        Vehicle vehicle1 = new Vehicle("BMW", 1, 0, 0);
        Vehicle vehicle2 = new Vehicle("BMW", 1, 0, 0);
        Vehicle vehicle3 = new Vehicle("Audi", 1, 0, 0);
        assertEquals(vehicle1, vehicle2);
        assertNotEquals(vehicle1, vehicle3);
    }
}