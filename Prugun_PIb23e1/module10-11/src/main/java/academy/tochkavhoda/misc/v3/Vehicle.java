package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;
import academy.tochkavhoda.iface.v3.Movable;
import academy.tochkavhoda.figures.v3.Point;
import java.util.Objects;

public class Vehicle implements Movable, Colored {
    private String name;
    private Color color;
    private Point position;

    public Vehicle(String name, Color color, int x, int y) throws ColorException {
        this.name = name;
        this.position = new Point(x, y);
        setColor(color);
    }

    public Vehicle(String name, Color color) throws ColorException {
        this(name, color, 0, 0);
    }

    public Vehicle(String name, String colorString, int x, int y) throws ColorException {
        this(name, Color.colorFromString(colorString), x, y);
    }

    public Vehicle(String name, String colorString) throws ColorException {
        this(name, Color.colorFromString(colorString), 0, 0);
    }

    public Vehicle() {
        this.name = "Vehicle";
        this.color = Color.RED;
        this.position = new Point(0, 0);
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
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
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