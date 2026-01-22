package academy.tochkavhoda.figures.v1;

public class CircleFactory {
    private static int circleCounter = 0;

    //Создает Circle по координатам центра и значению радиуса.
    public static Circle createCircle(Point center, int radius) {
        circleCounter++;
        return new Circle(center, radius);
    }

    //Возвращает количество Circle, созданных с помощью метода createCircle.
    public static int getCircleCount() {
        return circleCounter;
    }

    //Устанавливает количество Circle, созданных с помощью метода createCircle,
    //равным 0 (иными словами, реинициализирует фабрику).
    public static void reset() {
        circleCounter = 0;
    }
}
