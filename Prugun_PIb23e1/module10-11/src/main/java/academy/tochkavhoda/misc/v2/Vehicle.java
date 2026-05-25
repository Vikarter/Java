package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.figures.v2.Point;
import java.util.Objects;

public class Vehicle implements Movable, Colored {
    private String name;
    private int color;
    private Point position;

    public Vehicle(String name, int color, int x, int y) {
        this.name = name;
        this.color = color;
        this.position = new Point(x, y);
    }

    public Vehicle(String name, int color) {
        this(name, color, 0, 0);
    }

    public Vehicle() {
        this("Vehicle", 1, 0, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPosition() {
        return position;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void moveTo(int x, int y) {
        position.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        position.moveRel(dx, dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle v = (Vehicle) o;
        return color == v.color
                && Objects.equals(name, v.name)
                && Objects.equals(position, v.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, position);
    }
}