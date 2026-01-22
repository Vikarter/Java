package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {
    private int xLeft;
    private int yTop;
    private int xRight;
    private int yBottom;

    //1 Создает Square по координате левого верхнего угла и длине стороны
    public Square(Point leftTop, int size) {
        this.xLeft = leftTop.getX();
        this.yTop = leftTop.getY();
        this.xRight = leftTop.getX() + size;
        this.yBottom = leftTop.getY() + size;
    }

    //2 Создает Square по координате левого верхнего угла и длине стороны
    public Square(int xLeft, int yTop, int size) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.xRight = xLeft + size;
        this.yBottom = yTop + size;
    }

    //3 Создает Square, левый нижний угол которого находится в начале координат, а  длина стороны задается
    public Square(int size) {
        this.xLeft = 0;
        this.yBottom = 0;
        this.xRight = size;
        this.yTop = -size;
    }

    //4 Создает Square с длиной стороны 1, левый нижний угол которого находится в начале координат.
    public Square() {
        this(1);
    }

    //5 Возвращает левую верхнюю точку Square.
    public Point getTopLeft() {
        return new Point(xLeft, yTop);
    }

    //6 Возвращает правую нижнюю точку Square.
    public Point getBottomRight() {
        return new Point(xRight, yBottom);
    }

    //7 Устанавливает левую верхнюю точку Square.
    public void setTopLeft(Point topLeft) {
        int lenght = getLength();
        xLeft = topLeft.getX();
        yTop = topLeft.getY();
        xRight = xLeft + lenght;
        yBottom = yTop + lenght;
    }

    //8 Возвращает длину стороны квадрата
    public int getLength() {
        return xRight - xLeft;
    }

    //9 Передвигает Square в точку (x, y).
    public void moveTo(int x, int y) {
        int length = getLength();
        this.xLeft = x;
        this.yTop = y;
        this.xRight = x + length;
        this.yBottom = y + length;
    }

    //10 ередвигает Square в точку point
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    //11 Передвигает Square на (dx, dy).
    public void moveRel(int dx, int dy) {
        this.xLeft += dx;
        this.yTop += dy;
        this.xRight += dx;
        this.yBottom += dy;
    }

    //12 Изменяет обе стороны Square в ratio раз при сохранении координат левой верхней вершины.
    // Дробная часть координат отбрасывается.
    public void resize(double ratio) {
        int newLength = (int) (getLength() * ratio);
        xRight = xLeft + newLength;
        yBottom = yTop + newLength;
    }

    //13 Возвращает площадь квадрата
    public double getArea() {
        return (double) getLength() * getLength();
    }

    //14 Возвращает периметр квадрата.
    public double getPerimeter() {
        return 4.0 * getLength();
    }

    //15 Определяет, лежит ли точка (x, y) внутри Square.
    //Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    //16 Определяет, лежит ли точка point внутри Square.
    //Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    //17 Определяет, пересекается  ли Square с другим Square.
    //Считается, что прямоугольники пересекаются, если у них есть хоть одна общая точка.
    public boolean isIntersects(Square square) {
        return !(square.xRight < this.xLeft || square.xLeft > this.xRight ||
                square.yBottom < this.yTop || square.yTop > this.yBottom);
    }

    //18 Определяет, лежит ли Square целиком внутри текущего Square.
    public boolean isInside(Square square) {
        return square.xLeft >= this.xLeft && square.xRight <= this.xRight &&
                square.yTop >= this.yTop && square.yBottom <= this.yBottom;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return xLeft == square.xLeft && yTop == square.yTop &&
                xRight == square.xRight && yBottom == square.yBottom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xLeft, yTop, xRight, yBottom);
    }
}
