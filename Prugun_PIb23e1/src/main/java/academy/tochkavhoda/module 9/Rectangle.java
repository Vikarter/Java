package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Rectangle {
    private int xLeft;
    private int yTop;
    private int xRight;
    private int yBottom;

    //Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(Point leftTop, Point rightBottom) {
        this.xLeft = leftTop.getX();
        this.yTop = leftTop.getY();
        this.xRight = rightBottom.getX();
        this.yBottom = rightBottom.getY();
    }

    //Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.xRight = xRight;
        this.yBottom = yBottom;
    }

    //Создает Rectangle, левый нижний угол которого находится в начале координат,
    // а длина (по оси X) и ширина (по оси Y) задаются.
    public Rectangle(int length, int width) {
        this.xLeft = 0;
        this.yBottom = 0;
        this.xRight = length;
        this.yTop = -width;
    }

    //Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
    public Rectangle() {
        this(1,1);
    }

    //Возвращает левую верхнюю точку Rectangle.
    public Point getTopLeft() {
        return new Point(xLeft, yTop);
    }

    //Возвращает правую нижнюю точку Rectangle.
    public Point getBottomRight(){
        return new Point(xRight, yBottom);
    }

    //Устанавливает левую верхнюю точку Rectangle.
    public void setTopLeft(Point topLeft){
        xLeft = topLeft.getX();
        yTop = topLeft.getY();
    }

    //Устанавливает правую нижнюю точку Rectangle.
    public void setBottomRight(Point bottomRight){
        xRight = bottomRight.getX();
        yBottom = bottomRight.getY();
    }

    //Возвращает длину прямоугольника.
    public int getLength(){
        return xRight - xLeft;
    }

    //Возвращает ширину прямоугольника
    public int getWidth(){
        return yBottom - yTop;
    }

    //Передвигает Rectangle в точку (x, y).
    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        this.xLeft = x;
        this.yTop = y;
        this.xRight = x + length;
        this.yBottom = y + width;
    }

    //Передвигает Rectangle в точку point
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    //Передвигает Rectangle на (dx, dy).
    public void moveRel(int dx, int dy){
        this.xLeft += dx;
        this.yTop += dy;
        this.xRight += dx;
        this.yBottom += dy;
    }

    //Изменяет обе стороны Rectangle в ratio раз при сохранении координат левой верхней вершины.
    // Дробная часть координат отбрасывается.
    public void resize(double ratio){
        int newLength = (int) (getLength() * ratio);
        int newWidth = (int) (getWidth() * ratio);
        xRight = xLeft + newLength;
        yBottom = yTop + newWidth;
    }

    //Изменяет длину Rectangle в xRatio раз, а ширину в yRatio раз при сохранении
    // координат левой верхней вершины. Дробная часть координат отбрасывается.
    public void stretch(double xRatio, double yRatio){
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);
        this.xRight = this.xLeft + newLength;
        this.yBottom = this.yTop + newWidth;
    }

    //Возвращает площадь прямоугольника.
    public double getArea(){
        return (double) getLength() * getWidth();
    }

    //Возвращает периметр прямоугольника.
    public double getPerimeter() {
        return 2.0 * (getLength() + getWidth());
    }

    //Определяет, лежит ли точка (x, y) внутри Rectangle.
    // Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y){
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    //Определяет, лежит ли точка point внутри Rectangle.
    // Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(Point point){
        return  isInside(point.getX(), point.getY());
    }

    //Определяет, пересекается ли Rectangle с другим Rectangle.
    // Считается, что прямоугольники пересекаются, если у них есть хоть одна общая точка.
    public boolean isIntersects(Rectangle rectangle){
        return !(rectangle.xRight < this.xLeft || rectangle.xLeft > this.xRight ||
                rectangle.yBottom < this.yTop || rectangle.yTop > this.yBottom);
    }

    //Определяет, лежит ли rectangle целиком внутри текущего Rectangle.
    public boolean isInside(Rectangle rectangle){
        return rectangle.xLeft >= this.xLeft && rectangle.xRight <= this.xRight &&
                rectangle.yTop >= this.yTop && rectangle.yBottom <= this.yBottom;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return xLeft == rectangle.xLeft && yTop == rectangle.yTop &&
                xRight == rectangle.xRight && yBottom == rectangle.yBottom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xLeft, yTop, xRight, yBottom);
    }
}
