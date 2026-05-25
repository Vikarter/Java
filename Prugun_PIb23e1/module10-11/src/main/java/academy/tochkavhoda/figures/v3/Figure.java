package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.iface.v3.HasArea;
import academy.tochkavhoda.iface.v3.Movable;
import academy.tochkavhoda.iface.v3.Resizable;

public abstract class Figure implements Movable, Resizable, HasArea {
    public abstract boolean isInside(int x, int y);
    public abstract double getPerimeter();
    public abstract double getArea();

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }
}