package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Ellipse {
    private int xCenter;
    private int yCenter;
    private int xAxis;
    private int yAxis;

    //1 Создает Ellipse по координатам центра и размерам осей
    public Ellipse(Point center, int xAxis, int yAxis) {
        this.xCenter = center.getX();
        this.yCenter = center.getY();
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    //2 Создает Ellipse по координатам центра и размерам осей
    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    //3 Создает Ellipse с центром в точке (0,0) с указанными размерами осей
    public Ellipse(int xAxis, int yAxis) {
        this.xCenter = 0;
        this.yCenter = 0;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    //4 Создает Ellipse с центром в точке (0,0) и единичными размерами осей
    public Ellipse() {
        this(1, 1);
    }

    //5 Возвращает центр Ellipse.
    public Point getCenter() {
        return new Point(xCenter, yCenter);
    }

    //6 Возвращает размер оси Ellipse по X
    public int getXAxis() {
        return xAxis;
    }

    //7 Возвращает размер оси Ellipse по Y
    public int getYAxis() {
        return yAxis;
    }

    //8 Устанавливает размер оси Ellipse по X
    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    //9 Устанавливает размер оси Ellipse по Y
    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    //10 Устанавливает центр Ellipse.
    public void setCenter(Point center) {
        xCenter = center.getX();
        yCenter = center.getY();
    }

    //11 Передвигает Ellipse в точку (x, y).
    public void moveTo(int x, int y) {
        xCenter = x;
        yCenter = y;
    }

    //12 Передвигает Ellipse в точку point.
    public void moveTo(Point point) {
        xCenter = point.getX();
        yCenter = point.getY();
    }

    //13 Передвигает Ellipse на (dx, dy).
    public void moveRel(int dx, int dy) {
        xCenter += dx;
        yCenter += dy;
    }

    //14 Увеличивает оси Ellipse в n раз, не изменяя центра.
    // Дробная часть вычисленных осей отбрасывается
    public void resize(double ratio) {
        xAxis = (int) (getXAxis() * ratio);
        yAxis = (int) (getYAxis() * ratio);
    }

    //15 Увеличивает ось X Ellipse в xRatio раз и ось Y Ellipse в yRatio раз, не изменяя центра.
    // Дробная часть вычисленных осей отбрасывается
    public void stretch(double xRatio, double yRatio) {
        xAxis = (int) (getXAxis() * xRatio);
        yAxis = (int) (getYAxis() * yRatio);
    }

    //16 Возвращает площадь Ellipse.
    public double getArea() {
        return Math.PI * ((double) xAxis * yAxis) / 4.0;
    }

    //17 Возвращает периметр Ellipse
    public double getPerimeter() {
        return 2.0 * Math.PI * Math.sqrt(
                ((double) xAxis * xAxis + (double) yAxis * yAxis) / 8.0);
    }

    //18 Определяет, лежит ли точка (x, y) внутри Ellipse.
    // Если точка лежит на линии эллипса, считается, что она лежит внутри.
    public boolean isInside(int x, int y) {
        double xSemiaxis = xAxis / 2.0;
        double ySemiaxis = yAxis / 2.0;
        double dx = x - getCenter().getX();
        double dy = y - getCenter().getY();
        double val = (dx * dx) / (xSemiaxis * xSemiaxis) + (dy * dy) / (ySemiaxis * ySemiaxis);
        return val <= 1.0 + 1e-12;
    }

    //19 Определяет, лежит ли точка point внутри Ellipse.
    //Если точка лежит на линии эллипса, считается, что она лежит внутри.
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xCenter == ellipse.xCenter && yCenter == ellipse.yCenter && xAxis == ellipse.xAxis && yAxis == ellipse.yAxis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCenter, yCenter, xAxis, yAxis);
    }
}
