package academy.tochkavhoda.figures.v3;

import java.util.Objects;

public class Square extends Rectangle {

    public Square(Point topLeft, int side) {
        super(topLeft, new Point(topLeft.getX() + side, topLeft.getY() + side));
    }
    public Square(int x, int y, int side) { this(new Point(x, y), side); }
    public Square(int side)               { this(new Point(0, -side), side); }
    public Square()                       { this(1); }

    @Override
    public void setTopLeft(Point topLeft) {
        int side = getLength();
        super.setTopLeft(topLeft);
        super.setBottomRight(new Point(topLeft.getX() + side, topLeft.getY() + side));
    }
    @Override
    public void resize(double ratio) {
        int side = (int)(getLength() * ratio);
        super.setBottomRight(new Point(getTopLeft().getX() + side, getTopLeft().getY() + side));
    }

    public boolean isIntersects(Square other) { return super.isIntersects(other); }
    public boolean isInside(Square other)     { return super.isInside(other); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square s = (Square) o;
        return Objects.equals(getTopLeft(), s.getTopLeft()) && getLength() == s.getLength();
    }
    @Override public int hashCode() { return Objects.hash(getTopLeft(), getLength()); }
}