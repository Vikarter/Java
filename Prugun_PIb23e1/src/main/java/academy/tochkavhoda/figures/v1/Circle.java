package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Circle{
    private int xCenter;
    private int yCenter;
    private int radius;

    //1 Создает Circle по координатам центра и значению радиуса.
    public Circle(Point center, int radius){
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.radius = radius;
    }

    //2 Создает Circle по координатам центра и значению радиуса.
    public Circle(int xCenter, int yCenter, int radius){
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.radius = radius;
    }

    //3 Создает Circle с центром в точке (0,0) указанного радиуса
    public Circle(int radius){
        this.xCenter = 0;
        this.yCenter = 0;
        this.radius = radius;
    }

    //4 Создает Circle с центром в точке (0,0) с радиусом 1
    public Circle(){
        this(1);
    }

    //5 Возвращает центр Circle
    public Point getCenter(){
        return new Point(xCenter, yCenter);
    }

    //6 Возвращает радиус Circle.
    public int getRadius(){
        return radius;
    }

    //7 Устанавливает центр Circle
    public void setCenter(Point center){
        xCenter = center.getX();
        yCenter = center.getY();
    }

    //8 Устанавливает радиус Circle.
    public void setRadius(int radius){
        this.radius = radius;
    }

    //9 Передвигает Circle так, чтобы его центр оказался в точке  (x, y).
    public void moveTo(int x, int y){
        xCenter = x;
        yCenter = y;
    }

    //10 Передвигает Circle так, чтобы его центр оказался в точке point).
    public void moveTo(Point point) {
        xCenter = point.getX();
        yCenter = point.getY();
    }

    //11 Передвигает Circle на (dx, dy).
    public void moveRel(int dx, int dy) {
        xCenter += dx;
        yCenter += dy;
    }

    //12 Увеличивает радиус Circle в n раз, не изменяя центра.
    // Дробная часть вычисленного радиуса отбрасывается.
    public void resize(double ratio) {
        radius = (int) (getRadius() * ratio);
    }

    //13 Возвращает площадь круга.
    public double getArea() {
        return Math.PI * (double) radius * radius;
    }

    //14 Возвращает периметр окружности (длину окружности)
    public double getPerimeter() {
        return Math.PI * radius * 2.0;
    }

    //15 Определяет, лежит ли точка (x, y) внутри Circle.
    // Если точка лежит на окружности, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        double dx = x - getCenter().getX();
        double dy = y - getCenter().getY();
        return dx * dx + dy * dy <= (double) radius * radius + 1e-12;
    }

    //16 Определяет, лежит ли точка point внутри Circle.
    // Если точка лежит на окружности, считается, что она лежит внутри.
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return xCenter == circle.xCenter && yCenter == circle.yCenter && radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCenter, yCenter, radius);
    }
}
