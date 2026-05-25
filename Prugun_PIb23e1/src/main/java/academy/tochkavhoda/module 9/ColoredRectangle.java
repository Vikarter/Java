package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredRectangle extends Rectangle {

    //8
    public int getColor() {
        return color;
    }
    //11
    public void setColor(int color) {
        this.color = color;
    }

    private int color;


    //1. Создает ColoredRectangle по координатам углов основания (левого верхнего и правого нижнего) и цвету.
    public ColoredRectangle(Point leftTop, Point rightBottom, int color){
        super(leftTop, rightBottom);  // вызываем конструктор Rectangle(Point, Point)
        this.color = color;
    }
    //2. Создает ColoredRectangle по координатам углов основания (левого верхнего и правого нижнего) и цвету
    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color){
        super(xLeft, yTop, xRight, yBottom);  // вызываем конструктор Rectangle(int, int, int, int)
        this.color = color;
    }
    //3.  Создает ColoredRectangle, левый нижний угол которого находится в
    // начале координат, а  длина, ширина и цвет задаются.
    public ColoredRectangle(int length, int width, int color){
        super(length, width);  // вызываем конструктор Rectangle(int, int)
        this.color = color;
    }
    //4.Создает ColoredRectangle с размерами (1, 1) и указанным цветом,
    // левый нижний угол которого находится в начале координат.
    public ColoredRectangle(int color){
        super(1, 1);
        this.color = color;
    }

    //5. Создает ColoredRectangle с размерами (1, 1) и цветом 1,
    // левый нижний угол которого находится в начале координат.
    public ColoredRectangle(){
        super(1, 1);
        this.color = 1;
    }

    //6. Возвращает левую верхнюю точку ColoredRectangle.
    @Override
    public Point getTopLeft() {
        return super.getTopLeft();  // просто вызываем метод родителя
    }

    //7. Возвращает правую нижнюю точку ColoredRectangle.
    @Override
    public Point getBottomRight() {
        return super.getBottomRight();  // просто вызываем метод родителя
    }

    //9. Устанавливает левую верхнюю точку ColoredRectangle.
    @Override
    public void setTopLeft(Point topLeft) {
        super.setTopLeft(topLeft);
    }

    //10. Устанавливает правую нижнюю точку ColoredRectangle.
    @Override
    public void setBottomRight(Point bottomRight) {
        super.setBottomRight(bottomRight);  // вызываем метод родителя для изменения координат
        // Цвет при этом не меняется
    }
    //12. Возвращает длину ColoredRectangle.
    @Override
    public int getLength() {
        return super.getLength();  // просто вызываем метод родителя
    }

    //13. Возвращает ширину ColoredRectangle.
    @Override
    public int getWidth() {
        return super.getWidth();  // просто вызываем метод родителя
    }

    //14. Передвигает ColoredRectangle на (dx, dy).
    @Override
    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);  // просто вызываем метод родителя
    }
    //15. Изменяет обе стороны ColoredRectangle в ratio раз при сохранении координат левой верхней вершины.
    // Дробная часть координат отбрасывается.
    @Override
    public void resize(double ratio) {
        super.resize(ratio);  // просто вызываем метод родителя
        // Цвет при изменении размера не меняется
    }

    //16. Изменяет ширину ColoredRectangle в xRatio раз, а высоту в yRatio раз при сохранении
    // координат левой верхней вершины. Дробная часть координат отбрасывается.
    @Override
    public void stretch(double xRatio, double yRatio) {
        super.stretch(xRatio, yRatio);  // просто вызываем метод родителя
        // Цвет при изменении размера не меняется
    }

    //17. Возвращает площадь ColoredRectangle
    @Override
    public double getArea() {
        return super.getArea();  // просто вызываем метод родителя
    }

    //18. Возвращает периметр ColoredRectangle
    @Override
    public double getPerimeter() {
        return super.getPerimeter();  // просто вызываем метод родителя
    }

    //19. Определяет, лежит ли точка (x, y) внутри ColoredRectangle.
    // Если точка лежит на стороне, считается, что она лежит внутри.
    @Override
    public boolean isInside(int x, int y) {
        return super.isInside(x, y);  // просто вызываем метод родителя
    }

    //20. Определяет, лежит ли точка point внутри ColoredRectangle.
    // Если точка лежит на стороне, считается, что она лежит внутри.
    @Override
    public boolean isInside(Point point) {
        return super.isInside(point);  // просто вызываем метод родителя
    }
    //21. Определяет, пересекается ли ColoredRectangle с другим ColoredRectangle.
// Считается, что ColoredRectangle пересекаются, если у них есть хоть одна общая точка.
    public boolean isIntersects(ColoredRectangle rectangle) {
        // Используем метод родителя Rectangle.isIntersects()
        // Так как проверка пересечения зависит только от геометрии, а не от цвета
        return super.isIntersects(rectangle);
    }

    //22. Определяет, лежит ли ColoredRectangle целиком внутри текущего ColoredRectangle.
    public boolean isInside(ColoredRectangle rectangle) {
        // Используем метод родителя Rectangle.isInside()
        // Так как проверка вхождения зависит только от геометрии, а не от цвета
        return super.isInside(rectangle);
    }

    //23. методы equals и hashCode.
// Сгенерировано с помощью IDEA (Alt+Insert -> equals() and hashCode())
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
