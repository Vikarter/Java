package academy.tochkavhoda.introduction;

public class ZeroSteps2 {

    //Возвращает сумму квадратов целых чисел от 1 до count
    public int sumSquares(int count){
        int Sum=0;

        for(int i = 1; i <= count; i++){
            Sum += i*i;
        }
        return Sum;
    }

    //Возвращает сумму нечетных целых чисел от 1 до count
    public int sumOdds(int count){
        int sum = 0;

        for (int i = 1; i <= count; i++)
            if (i % 2 != 0)
                sum += i;
        return sum;
    }

    //Возвращает сумму обратных величин целых чисел от 1 до count
    public double sumInverses(int count){
        double Sum = 0;

        for(int i = 1; i <= count; i++){
            Sum += 1.0/i;
        }
        return Sum;
    }

    //Возвращает произведение целых чисел от 1 до count (факториал от count)
    public long factorial(int count){
        long product = 1;

        for(int i = 1; i <= count; i++){
            product *= i;
        }
        return product;
    }

    //Возвращает произведение цифр целого числа value
    public int prodDigits(int value){
        int product = 1;

        while(value > 0){
            product *= value % 10;
            value = value / 10;
        }
        return product;
    }

    //Возвращает число Фибоначчи (последовательность чисел,
    // где каждое следующее число равно сумме двух предыдущих.)
    public int fibonacci(int number){
        int a = 0;
        int b = 1;
        int c;

        if(number == 0)
            return number;

        if(number <= 2 && number > 0){
            number = 1;
            return number;
        }

        for(int i = 1;i<number;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    //Возвращает сумму всех степеней 2 от 2^0 до 2^max
    public long sum2Powers(int max){
        if (max == 0)
            return 1;
        if (max == 1)
            return 2 + 1;

        long result = 2;

        for (int i = max; i > 0; i--){
            result *= 2;
        }
        return result-1;
    }

    //Возвращает сумму квадратов целых чисел от 1 до count.
    // Суммирование прекращается как только
    //сумма станет больше barrier
    public int sumSquaresWithBarrier(int count, int barrier){
        int sum = 0;

        for (int i = 1; i <= count; i++) {
            if (sum >= barrier)
                break;
            sum += i * i;
        }
        return sum;
    }

    //Возвращает сумму всех произведений i*j
    // (1 <=i <= count1 и 1 <=j <= count2)
    public int sumPairProd(int count1, int count2){
        int sum = 0;

        for(int i = 1; i <= count1; i++){
            for(int j = 1; j <= count2; j++){
                sum += i * j;
            }
        }
        return sum;
    }

    //Возвращает сумму тех произведений i*j,
    // (1 <=i <= count1 и 1 <=j <= count2), которые меньше barrier
    public int sumPairProdWithBarrier(int count1, int count2, int barrier){
        int sum = 0;
        for(int i = 1;i <= count1; i++){
            for(int j = 1;j <= count2;j++){
                if (i * j < barrier)
                sum += i*j;
            }
        }
        return sum;
    }

    //Возвращает сумму всех величин 1/(i*j)
    // (1 <=i <= count1 и 1 <=j <= count2)
    public double sumInversePairProd(int count1, int count2){
        double sum = 0;

        for(int i = 1; i <= count1; i++){
            for(int j = 1; j <= count2; j++){
                sum += 1.0 / (i * j);
            }
        }
        return sum;
    }

    //Возвращает сумму всех произведений i*j *k
    // (1 <=i <= count1, 1 <=j <= count2, 1 <=k <= count3)
    public int sumTripleProd(int count1, int count2, int count3){
        int sum = 0;

        for(int i = 1; i <= count1; i++){
            for(int j = 1; j <= count2; j++){
                for(int k = 1; k<= count3; k++){
                    sum += (i * j * k);
                }
            }
        }
        return sum;
    }

    //Возвращает значение числа e, вычисляемое по следующей формуле
    //1 + 1/(1) + 1 / (1 * 2) + 1 / (1* 2 * 3) + 1 / (1* 2 * 3 * 4) + 1 / (1* 2 * 3 * 4 * 5) + …
    //Суммирование вести до тех пор, пока очередной элемент не станет меньше 1E-6
    public double calculateE(){
        double element;
        int x = 1;
        double sum = 1;

        for (int i = 1; ; i++) {
            x *= i;
            element = 1.0/x;
            sum += element;

            if(element <= 1E-6)
                break;
        }
        return sum;
    }

    //Возвращает значение числа, вычисляемое π по следующей формуле
    //4*(1 - 1/3 + 1/5 - 1/7 + 1/9 …)
    //Суммирование вести до тех пор, пока очередной элемент
    // по абсолютной величине не станет меньше 1E-8
    public double calculatePi(){
        double sum = 0;
        double symbol = 1.0;  // чтобы начать сплюса

        for(int i = 0; ; i++) {
            double denominator = 2 * i + 1;  // знаменатель
            double element = symbol / denominator;  // текущий элемент

            if(Math.abs(element) < 1E-8) {
                break;
            }

            sum += element;
            symbol = -symbol;
        }
        return 4 * sum;
    }

    /*На плоскости задан квадрат со стороной length и вписанный в него круг, Центр квадрата (и ,
    следовательно, круга) находится в точке (length/2, length/2) Случайным образом count раз выбирается
    точка, лежащая внутри квадрата. Эта точка может оказаться внутри круга или нет.
    Вычислить площадь круга по формуле
    S = length * length * k / count
    где k - количество точек, попавших в круг
    Этот метод носит название “метод Монте-Карло”, точность его невысока.*/
    public double calculateCircleSquare(double length, int count){
        int kolvo = 0; // количество точек, попавших в круг
        double centerX = length / 2.0;
        double centerY = length / 2.0;// Центр круга и квадрата
        double radius = length / 2.0;// Радиус круга

        for (int i = 0; i < count; i++) {
            double x = Math.random() * length;
            double y = Math.random() * length;// Случайные координаты x и y точки внутри квадрата
            double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)); // Расстояние от точки до центра круга
            // Проверка, находится ли точка внутри круга
            if (distance <= radius)
                kolvo++; // точка попала в круг
        }
        // Вычисляется площадь круга по формуле
        double square = length * length * kolvo / count;
        return square;
    }
}

