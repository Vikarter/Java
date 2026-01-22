package academy.tochkavhoda.introduction;

public class ZeroSteps4 {

    //Возвращает минимальное из чисел, заданных двумерным массивом matrix. Для пустого двумерного
    //массива возвращает Integer.MAX_VALUE.
    public int min(int[][] matrix){
        int minValue = Integer.MAX_VALUE;

        if (matrix.length == 0)
            return Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minValue)
                    minValue = matrix[i][j];
            }
        }
        return minValue;
    }

    //Возвращает максимальное из чисел, заданных двумерным массивом matrix. Для пустого двумерного
    //массива возвращает Integer.MIN_VALUE.
    public int max(int[][] matrix){
        int maxValue = Integer.MIN_VALUE;

        if (matrix.length == 0)
            return Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] > maxValue)
                    maxValue = matrix[i][j];
            }
        }
        return maxValue;
    }

    //Возвращает true, если в двумерном массиве matrix имеется элемент, равный value, иначе false.
    public boolean find(int[][] matrix, int value){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == value)
                    return true;
            }
        }
        return false;
    }

    //Возвращает true, если все строки двумерного массива matrix строго упорядочены по убыванию, иначе
    //false. Пустая строка считается упорядоченной.
    public boolean isSortedDescendant(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++){
                if (matrix[i][j] <= matrix[i][j + 1])
                    return false;
            }
        }
        return true;
    }

    //Возвращает количество строк двумерного массива matrix, не содержащих нулевого элемента.
    public int hasNoZeroRows(int[][] matrix){
        int count = 0; //счетчик строк, не содержащих ноль

        for (int i = 0; i < matrix.length; i++){
            int foundZero = 0; //флаг становится 1, если находим ноль. Обнуляется при новой итерации

            for (int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    foundZero = 1;
                    break;
                }
            }

            if (foundZero == 0)  // если не нашли нули, то флаг = 0, и увеличивается счетчик
                count++;
        }
        return count;
    }

    //Возвращает true, если в двумерном массиве matrix есть хотя бы одна строка, состоящая только из
    //нулевых элементов, иначе false.
    public boolean hasFullZeroRow(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            int foundNonZero = 0; // флаг становится 1, если найдена строка без нулей. Если флаг = 0, строка с нулями

            if (matrix[i].length == 0) // если строка пустая, то пропустить ее
                continue;

            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] != 0) {
                    foundNonZero = 1;
                    break;
                }
            }

            if (foundNonZero == 0)
                return true;
        }
        return false; // не нашли строки полностью из нулей
    }

    //Возвращает true, если в квадратном двумерном массиве matrix все элементы симметричны
    //относительно главной диагонали (то есть a[i][j] == a[j][i]), иначе false.
    public boolean isSymmetric(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = i + 1; j < matrix[i].length; j++){
                if (matrix[i][j] != matrix[j][i]) // сравнение элементов ниже и выше диагонали
                    return false; // значит не равны
            }
        }
        return true;
    }

    //Возвращает максимальное из чисел, находящихся на главной диагонали квадратного двумерного
    //массива matrix. Для пустого двумерного массива возвращает Integer.MIN_VALUE
    public int mainDiagonalMax(int[][] matrix){
        int max = Integer.MIN_VALUE;

        if (matrix.length == 0)
            return Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i] != null && i < matrix[i].length)
                if (matrix[i][i] > max)
                    max = matrix[i][i];
        }
        return max;
    }

    //Возвращает сумму положительных элементов главной диагонали квадратного двумерного массива
    //matrix.
    public int mainDiagonalPositivesSum(int[][] matrix){
        int sum = 0;

        for (int i = 0; i < matrix.length; i++){
            if (i < matrix[i].length && matrix[i][i] > 0)//если элемент положительный и есть в строке, то прибавляется к сумме
                sum += matrix[i][i];
        }
        return sum;
    }

    //Возвращает максимальное из чисел, находящихся на побочной диагонали квадратного двумерного
    //массива matrix. Для пустого двумерного массива возвращает Integer.MIN_VALUE
    public int secondaryDiagonalMax(int[][] matrix){
        if (matrix.length == 0)
            return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++){
            int j = matrix.length - 1 - i; // высчитывается индекс j для элементов побочной диагонали

            if (matrix[i] != null && j < matrix[i].length) //если элемент есть в строке, то его значение сравнивается с max
                if (matrix[i][j] > max)
                    max = matrix[i][j];
        }
        return max;
    }

    //Возвращает сумму положительных элементов побочной диагонали квадратного двумерного массива
    //matrix.
    public int secondaryDiagonalPositivesSum(int[][] matrix){
        int sum = 0;

        for (int i = 0; i < matrix.length; i++){
            int j = matrix.length - 1 - i; // высчитывается индекс j для элементов побочной диагонали

            if (matrix[i] != null && j < matrix[i].length)
                if(matrix[i][j] > 0)
                    sum += matrix[i][j];
        }
        return sum;
    }

    //Возвращает сумму двух двумерных массивов matrix1 и matrix2 одинаковых размеров. Суммой
    //является новый двумерный массив того же размера, элементы которого вычисляются по формуле
    //matrix1[i][j] + matrix2[i][j]. Строки массивов могут иметь разную длину, в том числе и нулевую.
    public int[][] matrixSum(int[][] matrix1, int[][]matrix2){
        int[][] result = new int[matrix1.length][];

        if (matrix1 == null || matrix2 == null)
            return null;

        for (int i = 0; i < result.length; i++){
            if (matrix1[i] == null && matrix2[i] == null)// если обе строки пустые, в результате будет пустая строка
                result[i] = null;

            else if (matrix1[i] == null)
                result[i] = matrix2[i];

            else if (matrix2[i] == null)
                result[i] = matrix1[i];

            else{
                int lineLength = Math.min(matrix1[i].length, matrix2[i].length);// длина строки = мин.строка данных массивов
                result[i] = new int[lineLength];

                for (int j = 0; j < lineLength; j++){ // заполнение строки после определения ее размера
                    result[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
        }
        return result;
    }

    //Транспонирует квадратный массив matrix, то есть меняет друг с другом значения matrix[i][j] и
    //matrix[j][i] для всех i, j
    public void transpose(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){//проход по верхнему треугольнику, гл.диаг. остается неизменнной
            for (int j = i + 1; j < matrix[i].length; j++){
                int element = matrix[i][j]; // старое значение верхнего элемента
                matrix[i][j] = matrix[j][i]; // верхний меняется с нижним местами
                matrix[j][i] = element;// в нижний записывается сохраненное значение верхнего
            }
        }
    }

    //Меняет местами четные и нечетные строки двумерного массива matrix. Количество строк в массиве
    //четное. Строки массивов могут иметь разную длину, в том числе и нулевую.
    public void interchange(int[][] matrix){
        for (int i = 0; i < matrix.length; i += 2){
            int[] oldLine = matrix[i];// запись четной строки в переменную
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = oldLine;
        }
    }

    //По двумерному массиву matrix делает одномерный массив, переписывая туда все элементы matrix,
    //при проходе ее по строкам. Строки matrix могут иметь разную длину, в том числе и нулевую.
    public int[] toLinearByRow(int[][] matrix){
        int countElements = 0;//суммарное количество элементов matrix

        for (int i = 0; i < matrix.length; i++){// подсчет кол-ва элементов
            if (matrix[i] != null)
                countElements += matrix[i].length;
        }

        int[] result = new int[countElements];//создание конечного массива
        int indexElement = 0;

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i] != null) {
                for (int j = 0; j < matrix[i].length; j++){
                    result[indexElement] = matrix[i][j];
                    indexElement++;
                }
            }
        }
        return result;
    }

    //По двумерному квадратному массиву matrix делает одномерный массив, переписывая туда все
    //элементы matrix, при проходе ее по столбцам.
    public int[] toLinearByColumn(int[][] matrix){
        int countElements = 0;//суммарное количество элементов matrix

        for (int i = 0; i < matrix.length; i++){// подсчет элементов
            if (matrix[i] != null)
                countElements += matrix[i].length;
        }

        int[] result = new int[countElements];//создание конечного массива
        int indexElement = 0;
        int countColumns = 0;//количество столбцов

        for (int i = 0; i < matrix.length; i++){//цикл позволяет узнать количество столбцов
            if ((matrix[i] != null) && (matrix[i].length > countColumns))
                countColumns = matrix[i].length;
        }

        for (int j = 0; j < countColumns; j++){// проход по столбцам
            for (int i = 0; i < matrix.length; i++){// проход по строкам
                if ((matrix[i] != null) && (j < matrix[i].length)){// если строка не пустая и нет выхода за границы строки
                    result[indexElement] = matrix[i][j];//то элемент добавляется в конечный массив
                    indexElement++;
                }
            }
        }
        return result;
    }

    //По двумерному квадратному массиву matrix делает одномерный массив, переписывая туда все
    //элементы верхнего треугольника matrix (то есть элементы на главной диагонали и выше ее), при
    //проходе ее по строкам.
    public int[] toLinearByRowUpperTriangle(int[][] matrix){
        int countElements = 0;

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i] != null)
                countElements += Math.max(0, matrix[i].length - i);//количество элементов верхнего треугольника и гл.диаг.
        }

        int[] result = new int[countElements];
        int indexElement = 0;

        for (int i = 0; i < matrix.length; i++){
            if (matrix[i] != null)
                for (int j = i; j < matrix[i].length; j++){
                    result[indexElement] = matrix[i][j];
                    indexElement++;
                }
        }
        return result;
    }

    //Находит сумму элементов двумерного массива matrix, проходя его по строкам. В каждой строке
    //    суммируются элементы ее, пока не встретится элемент со значением barrier, его в сумму не
    //    включают. Если такой элемент не встретится, в сумму добавляются все элементы данной строки
    //    матрицы. Строки matrix могут иметь разную длину, в том числе и нулевую.
    public int sumUntilNotFoundInRow(int[][] matrix, int barrier){
        int sumElements = 0;

        for (int i = 0; i < matrix.length; i++) {
            if ((matrix[i] == null) || (matrix[i].length == 0)) //eсли строки нет или она пустая, то пропуск строки
                continue;

            for (int j = 0; j < matrix[i].length; j++){
                if (matrix[i][j] == barrier)//если встретилось число-барьер, то суммирование останавливается
                    break;

                else
                sumElements += matrix[i][j];//в ином случае число добавляется к сумме
            }
        }
        return sumElements;
    }

    // Находит сумму элементов двумерного массива matrix, проходя его по строкам пока не встретится
    //    элемент со значением barrier, его в сумму не включают. Если такой элемент не встретится, находит
    //    сумму всех элементов матрицы. Строки matrix могут иметь разную длину, в том числе и нулевую.
    public int sumUntilNotFound(int[][] matrix, int barrier){
        int sumElements = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null) //пропуск пустых строк
                continue;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == barrier)
                    return sumElements;

                else
                sumElements += matrix[i][j];
            }
        }
        return sumElements;
    }
}



