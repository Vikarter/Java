package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.HasArea;
import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.iface.v2.Resizable;

public abstract class Figure implements Movable, Resizable, HasArea {
    public abstract boolean isInside(int x, int y);
    public abstract double getPerimeter();
    public abstract double getArea();

    // НЕ абстрактный — один раз написали, работает для всех
    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }
}