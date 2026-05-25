package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredCircle extends Circle {
    private int color;

    // Геттер и сеттер для цвета
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    //1. Создает ColoredCircle по координатам центра, значению радиуса и цвету.
    public ColoredCircle(Point center, int radius, int color) {
        super(center, radius);
        this.color = color;
    }

    //2. Создает ColoredCircle по координатам центра, значению радиуса и цвету.
    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        super(xCenter, yCenter, radius);
        this.color = color;
    }

    //3. Создает ColoredCircle с центром в точке (0, 0) с указанными радиусом и цветом.
    public ColoredCircle(int radius, int color) {
        super(radius);
        this.color = color;
    }

    //4. Создает ColoredCircle с центром в точке (0, 0) с радиусом 1 и указанным цветом.
    public ColoredCircle(int color) {
        super(1);
        this.color = color;
    }

    //5. Создает ColoredCircle с центром в точке (0, 0) с радиусом 1 и цветом 1.
    public ColoredCircle() {
        super(1);
        this.color = 1;
    }

    //6. Возвращает координаты центра ColoredCircle.
    // Этот метод уже есть в родителе Circle, но если нужно явно объявить:
    @Override
    public Point getCenter() {
        return super.getCenter();
    }

    //7. Возвращает радиус ColoredCircle.
    // Этот метод уже есть в родителе Circle, но если нужно явно объявить:
    @Override
    public int getRadius() {
        return super.getRadius();
    }

    //8. Устанавливает координаты центра ColoredCircle.
    @Override
    public void setCenter(Point center) {
        super.setCenter(center);  // вызываем метод родителя
        // Цвет при этом не меняется
    }

    //9. Устанавливает радиус ColoredCircle.
    @Override
    public void setRadius(int radius) {
        super.setRadius(radius);  // вызываем метод родителя
        // Цвет при этом не меняется
    }

    //12. Передвигает ColoredCircle на (dx, dy).
    @Override
    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);  // вызываем метод родителя
        // Цвет при этом не меняется
    }

    //13. Увеличивает радиус ColoredCircle в n раз, не изменяя центра.
    // Дробная часть вычисленного радиуса отбрасывается.
    @Override
    public void resize(double ratio) {
        super.resize(ratio);  // вызываем метод родителя
        // Цвет при изменении радиуса не меняется
    }

    //14. Возвращает площадь круга для ColoredCircle
    @Override
    public double getArea() {
        return super.getArea();  // вызываем метод родителя
    }

    //15. Возвращает периметр окружности для ColoredCircle
    @Override
    public double getPerimeter() {
        return super.getPerimeter();  // вызываем метод родителя
    }

    //16. Определяет, лежит ли точка (x, y) внутри ColoredCircle.
    // Если точка лежит на линии, считается, что она лежит внутри.
    @Override
    public boolean isInside(int x, int y) {
        return super.isInside(x, y);  // вызываем метод родителя
    }

    //17. Определяет, лежит ли точка point внутри ColoredCircle.
    // Если точка лежит на линии, считается, что она лежит внутри.
    @Override
    public boolean isInside(Point point) {
        return super.isInside(point);  // вызываем метод родителя
    }

    //18. методы equals и hashCode.
    // Сгенерировано с помощью IDEA (Alt+Insert -> equals() and hashCode())
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    @Override
    public String toString() {
        return "ColoredCircle{" +
                "center=(" + getCenter().getX() + ", " + getCenter().getY() + ")" +
                ", radius=" + getRadius() +
                ", color=" + color +
                '}';
    }
}
