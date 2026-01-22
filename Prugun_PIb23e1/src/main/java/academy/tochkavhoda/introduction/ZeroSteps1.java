package academy.tochkavhoda.introduction;

public class ZeroSteps1 {

    //Возвращает сумму чисел x и y.
    public int sum (int x, int y){
        return x + y;
    }

    //Возвращает произведение чисел x и y.
    public int mul (int x, int y){
        return x * y;
    }

    // Возвращает частное от деления чисел x и y. Гарантируется, что y != 0.
    public int div (int x, int y){
        return x/y;
    }

    //Возвращает остаток от деления чисел x и y. Гарантируется, что y != 0.
   public int mod (int x, int y){
        return x % y;
   }

    //Возвращает true, если x равен y, иначе false.
    public boolean isEqual (int x, int y){
        return x == y;
    }

    //Возвращает true, если x больше y, иначе false.
    public boolean isGreater (int x, int y){
        return x > y;
    }

    //Прямоугольный треугольник задан двумя катетами. Найти его площадь.
    public double calculateTriangleSquare(int side1, int side2){
        return (double) (side1 * side2) / 2;
    }

    //Прямоугольный треугольник задан двумя катетами. Найти его периметр.
    public double calculateTrianglePerimeter(int side1, int side2){
        return Math.sqrt(Math.pow(side1,2) + Math.pow(side2,2)) + side1 + side2;
    }

    /*Дано целое трехзначное число. Получить число, которое получится из него путем выписывания его
    цифр в обратном порядке.*/
    public int reverseNumber(int number){
        int element1 = number / 100;
        int element2 = (number % 100) / 10;
        int element3 = number % 10;

        return element3 * 100 + element2 * 10 + element1;
    }

    //Дано целое число. Возвести его в степень 15, используя не более 5 умножений.
    public long calculate15Degree(int number){
        return (long)Math.pow(number, 15);
    }

    /*Прямоугольник с горизонтальными и вертикальными сторонами, задан двумя точками - левой верхней
(xLeft, yTop) и правой нижней (xRight, yBottom). На плоскости OXY ось X направлена вправо, ось Y -
вниз. Дана еще одна точка с координатами (x, y). Гарантируется, что xLeft < xRight и yTop < yBottom.
Метод должен возвращать true, если точка лежит внутри прямоугольника , иначе false. Если точка лежит
на границе прямоугольника, то считается, что она лежит внутри него.*/
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y){
        if (x >= xLeft && x <= xRight)
            return y >= yTop && y <= yBottom;
        return false;
    }

    //Находит квадратный корень абсолютной величины числа (т.е модуль)
    public double sqrtAbs(int number){
        return  Math.sqrt(Math.abs(number));
    }

    //Возвращает true, если существует ли треугольник с такими тремя сторонами, иначе false
    public boolean isTriangleExist(int side1, int side2, int side3){
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }

    //Возвращает произведение цифр четырехзначного целого числа.
    public int getDigitsProduction(int number){
        int element1 = number / 1000;
        int element2 = (number/100) % 10;
        int element3 = (number%100) / 10;
        int element4 = number % 10;
        return element1 * element2 * element3 * element4;
    }

    /*Возвращает true, если круг радиуса radius может поместиться внутри квадрата со стороной side, не
    касаясь окружности, иначе false*/
    public boolean isCircleInsideSquare(int radius, int side){
        if(2 * radius < side)
            return true;
        return false;
    }

    //Возвращает символ с кодом code
    public char getCharByCode(short code){
        return (char) code;
    }

    //Возвращает код символа character
    public short getCodeByChar(char character){
        return (short) character;
    }

    //Возвращает код символа, который имеет код на offset больше, чем символ ch.
    public char getCharByCodeAndOffset(char ch, short offset){
        return (char) (ch + offset);
    }

    //Возвращает true, если код ch1 больше или равен коду ch2, иначе false
     public boolean isGreaterOrEqual(char ch1, char ch2){
         if (ch1 >= ch2)
             return true;
         return false;
    }

    //Возвращает символ с кодом, равном полусумме кодов ch1 и ch2
    public char getAverageChar(char ch1, char ch2){
        return (char)((ch1 + ch2) / 2);
    }

}
