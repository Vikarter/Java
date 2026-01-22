package academy.tochkavhoda.introduction;
import java.util.Arrays;
public class ZeroSteps3 {

    //Возвращает сумму чисел, заданных одномерным массивом array. Для пустого одномерного массива
    //возвращает 0
    public int sum(int[] array){
        int sum = 0;

        if(array.length == 0)
            return 0;

        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    //Возвращает произведение чисел, заданных одномерным массивом array.
    // Для пустого одномерного массива возвращает 0.
    public int mul(int[] array){
        int product = 1;

        if(array.length == 0)
            return 0;

        for(int i = 0; i < array.length; i++){
            product *= array[i];
        }
        return product;
    }

    //Возвращает минимальное из чисел, заданных одномерным массивом array.
    // Для пустого одномерного массива возвращает Integer.MAX_VALUE.
    public int min(int[] array){
        if(array.length == 0)
            return Integer.MAX_VALUE;

        int minNumber = array[0]; //первый элемент массив

        for(int i = 1; i < array.length; i++){
            if(array[i] < minNumber)
                minNumber = array[i];
        }
        return minNumber;
    }

    // Возвращает максимальное из чисел, заданных одномерным массивом array.
    // Для пустого одномерного массива возвращает Integer.MIN_VALUE.
    public int max(int[] array){
        if(array.length == 0)
            return Integer.MIN_VALUE;

        int maxNumber = array[0];

        for(int i = 1; i < array.length; i++){
            if(array[i] > maxNumber)
                maxNumber = array[i];
        }
        return maxNumber;
    }

    // Возвращает среднее значение для чисел, заданных одномерным массивом array.
    // Для пустого одномерного массива возвращает 0.
    public double average(int[] array){
        double sum = 0;

        if(array.length == 0)
            return 0;

        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum /= array.length;
    }

    //Возвращает true, если одномерный массив array строго упорядочен по убыванию, иначе false.
    // Пустой одномерный массив считается упорядоченным.
    public boolean isSortedDescendant(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] <= array[i+1])
                return false;
        }
        return true;
    }

    //Возводит все элементы одномерного массива array в куб.
    public void cube(int[]array){
        for(int i = 0; i < array.length; i++){
            array[i] = (int)Math.pow(array[i], 3);
        }
    }

    //Возвращает true,
    // если в одномерном массиве array имеется элемент, равный value, иначе false.
    public boolean find(int[]array, int value){
        for(int i = 0; i < array.length; i++){
            if(array[i] == value)
                return true;
        }
        return false;
    }

    //Переворачивает одномерный массив array, то есть меняет местами 0-й и
    // последний, 1-й и предпоследний и т.д. Элементы.
    public void reverse(int[]array){
        for(int i = 0; i < array.length / 2; i++){
            int currentElement = array[i]; //текущий
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = currentElement; //элементы меняются местами
        }
    }

    // Возвращает true, если одномерный массив является палиндромом(элементы на первой и последней позиции совпадают,
    // элементы на второй и предпоследней позиции совпадают и так далее), иначе false.
    // Пустой массив считается палиндромом.
    public boolean isPalindrome(int[]array){
        int j = array.length;
        for(int i = 0; i < array.length; i++){
            if(array[i] != array[j-1])
                return false;
            j--;
        }
        return true;
    }

    // Заменяет элементы массива array на их квадраты,
    // пока не встретится нулевой элемент
    public void replaceBySquare(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                break;
            array[i] = array[i] * array[i];
        }
    }

    //Возвращает произведение ненулевых чисел, заданных одномерным массивом array. Для пустого
    //одномерного массива возвращает 0.
    public int mulNonZero(int[] array){
        int result = 1;

        if (array.length == 0)
            return 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0)
                result *= array[i];
        }

        if (result == 1)//если result = 1,то все элементы нули
            return 0;
        return result;
    }

    //Возвращает true, если все элементы массива положительные,
    // иначе false. Для пустого одномерного
    //массива возвращает false.
    public boolean allPositive(int[] array){
        if (array.length == 0)
            return false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0)
                return false;
        }
        return true;
    }

    //Возвращает true, если все элементы массива
    // равны между собой, иначе false. Для пустого
    //одномерного массива возвращает true.
    public boolean allEqual(int[] array){
        if (array.length == 0)
            return true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1])
                return false;
        }
        return true;
    }

    /*Возвращает индекс первого элемента, который больше своих соседей.
     Нулевой и последний элементы не учитываются.
     Если такого элемента нет, возвращает -1*/
    public int greaterThanNeighbours(int[] array){
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1])
                return i;
        }
        return -1;
    }

    /*Определяет, есть ли среди элементов массива array такой элемент,
    который равен полусумме своих соседей. Нулевой и последний элементы не учитываются.*/
    public boolean neighboursAverage(double[] array){
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] == (array[i-1] + array[i+1]) / 2)
                return true;
        }
        return false;
    }

    /*В массиве array есть ровно 2 нулевых элемента.
    Возвращает сумму элементов массива, стоящих между ними.*/
    public int sumBetween2Zeros(int[] array){
        int sum = 0;
        int firstZeroIndex=0;
        int secondZeroIndex=0;

        for (int i = 0; i < array.length; i++) {//поиск первого нуля
            if (array[i] == 0) {
                firstZeroIndex = i;
                break;
            }
        }

        for (int i = firstZeroIndex + 1; i < array.length; i++) {//поиск второго нуля
            if (array[i] == 0) {
                secondZeroIndex = i;
                break;
            }
        }

        for (int i = firstZeroIndex + 1; i < secondZeroIndex; i++){//считается сумма между нулями
            sum += array[i];
        }
        return sum;
    }

    /*Возвращает количество элементов, для которых совпадают значения в одной и той же позиции в
    обоих массивах. Не гарантируется, что массивы имеют одинаковую длину.*/
    public int sameAtPosition(int[] array1, int[]array2){
        int count = 0;
        int length = array1.length;//предположительно, что первый массив короче второго

        //Если второй массив короче первого, уже его длина записывается в переменную
        if (array2.length < length)
            length = array2.length;

        for (int i = 0; i < length; i++){//берется как раз длина короткого массива
            if (array1[i] == array2[i])
                count++;
        }
        return count;
    }

    //Возвращает true, если есть хотя бы одна позиция в массивах, для которой элементы в обоих массивах
    //нулевые. Не гарантируется, что массивы имеют одинаковую длину.
    public boolean bothZeroAtPosition(int[] array1, int[]array2){
        int length = array1.length;//предположительно, что первый массив короче второго

        //Если второй массив короче первого, уже его длина записывается в переменную
        if (array2.length < length)
            length = array2.length;

        for (int i = 0; i < length; i++) {//берется как раз длина короткого массива
            if (array1[i] == 0 && array2[i] == 0)
                return true;
        }
        return false;
    }

    /*Заменяет все элементы массива array по следующему правилу: i-ый элемент массива должен стать
    равен сумме всех элементов массива с индексами от 0 до i (т.н. сумма с накоплением).*/
    public void accumulatedSum(int[] array){
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i - 1];
        }
    }

    //Массивы array1 и array2 гарантированно упорядочены по возрастанию и имеют ненулевую длину.
    //Возвращает массив, содержащий все элементы обоих массивов, который должен быть упорядочен по
    //неубыванию.
    public int[] mergeArrays(int[] array1, int[] array2){
        int[] result = new int[array1.length + array2.length];

        //добавление элементов из первого
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }

        //добавление из второго
        for (int i = 0; i < array2.length; i++) {
            result[array1.length + i] = array2[i];
        }

        Arrays.sort(result);
        return result;
    }

    /*Возвращает количество точек, попадающих в круг радиуса radius с центром в точке (0,0). Координаты
    точек задаются двумя массивами x и y, имеющими одинаковую длину. Точки, попадающие на линию
    окружности, считаются попавшими в круг.*/
    public int insideCircle(int[] x, int[] y, int radius){
        int count = 0;//количество точек в круге

        for (int i = 0; i < x.length; i++) {
            double sumPoint = Math.sqrt(x[i] * x[i] + y[i] * y[i]);//по формуле, если окр в 0.0, то x^2+y^2=r^2
            if (sumPoint <= radius)//если сумма точек меньше или равна r, то они входят в круг
                count++;
        }
        return count;
    }

    /*Найти сумму попарных произведений элементов двух массивов (т.н. Скалярное произведение), то
    есть array1[0] * array2[0] + array1[1] * array2[1]+ ... Массивы имеют одинаковую длину*/
    public double scalarProduct(double[] array1, double[] array2){
        double sum = 0;

        for (int i = 0; i < array1.length; i++) {
            sum += array1[i] * array2[i];
        }
        return sum;
    }
}
