package academy.tochkavhoda.base;

public class StringOperations {

    //1 Возвращает суммарную длину строк, заданных массивом strings.
    public static int getSummaryLength(String[] strings) {
        int x = 0;
        for (int i = 0; i < strings.length; i++) {
            x += strings[i].length();
        }
        return x;
    }

    //2 Возвращает двухсимвольную строку, состоящую из начального и конечного символов заданной строки.
    public static String getFirstAndLastLetterString(String string) {
        String str = "" + string.charAt(0) + string.charAt(string.length()-1);//через стрингбилдер лучше!
        return str;
    }

    //3 Возвращает true, если обе строки в позиции index содержат один и тот же символ, иначе false.
    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        if (string1.charAt(index) == string2.charAt(index))
            return true;
        else
            return false;
    }

    //4 Возвращает true, если в обеих строках первый встреченный символ character находится
    // в одной и той же позиции. Просмотр строк ведется от начала.
    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);

    }

    //5 Возвращает true, если в обеих строках первый встреченный символ character
    // находится в одной и той же позиции. Просмотр строк ведется от конца.
    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return (string1.lastIndexOf(character) == string2.lastIndexOf(character));

    }

    //6 Возвращает true, если в обеих строках первая встреченная подстрока str
    // начинается в одной и той же позиции. Просмотр строк ведется от начала.
    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return (string1.indexOf(str) == string2.indexOf(str));

    }

    //7 Возвращает true, если в обеих строках первая встреченная подстрока str
    // начинается в одной и той же позиции. Просмотр строк ведется от конца.
    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return (string1.lastIndexOf(str) == string2.lastIndexOf(str));
    }

    //8 Возвращает true, если строки равны.
    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    //9 Возвращает true, если строки равны без учета регистра
    // (например, строки “abc” и “aBC” в этом смысле равны).
    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    //10 Возвращает true, если строка string1 меньше строки string2.
    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    //11 Возвращает true, если строка string1 меньше строки string2 без учета регистра
    // (например, строка “abc” меньше строки “ABCd” в этом смысле).
    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.toLowerCase().compareTo(string2.toLowerCase()) < 0;
    }

    //12 Возвращает строку, полученную путем сцепления двух строк
    public static String concat(String string1, String string2) {
        return string1 + string2;//стрингбилдер!
    }

    //13 Возвращает true, если обе строки string1 и string2 начинаются с одной и той же подстроки prefix.
    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    //14 Возвращает true, если обе строки string1 и string2 заканчиваются одной и той же подстрокой suffix.
    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    //15 Возвращает самое длинное общее “начало” двух строк. Если у строк нет общего начала, возвращает пустую строку.
    public static String getCommonPrefix(String string1, String string2) {
        String str = "";
        for (int i = 0; i < Math.min(string1.length(), string2.length()); i++) {
            if (string1.charAt(i) == string2.charAt(i))
                str += string1.charAt(i);
            else break;
        }
        return str;
    }

    //16 Возвращает перевернутую строку.
    public static String reverse(String string){
        return new StringBuilder(string).reverse().toString();
    }

    // 17 Возвращает true, если строка является палиндромом,
    // то есть читается слева направо так же, как и справа налево.
    public static boolean isPalindrome(String string){
        return string.equals(reverse(string));
    }

    //18 Возвращает true, если строка является палиндромом, то есть читается
    // слева направо так же, как и справа налево, без учета регистра.
    public static boolean isPalindromeIgnoreCase(String string){
        return string.equalsIgnoreCase(reverse(string));
    }

    //19 Возвращает самый длинный палиндром (без учета регистра) из массива заданных строк.
    // Если в массиве нет палиндромов, возвращает пустую строку.
    public static String getLongestPalindromeIgnoreCase(String[] strings){
        String longestPalindrome = "";

        for (int i = 0; i < strings.length; i++) {
            String currentString = strings[i];

            if (isPalindromeIgnoreCase(currentString)) {
                //Если это палиндром и он длиннее найденного ранее
                if (currentString.length() > longestPalindrome.length()) {
                    longestPalindrome = currentString;
                }
            }
        }
        return longestPalindrome;
    }

    //20 Возвращает true, если обе строки содержат один и тот же фрагмент длиной length, начиная с позиции index.
	 public static boolean hasSameSubstring(String string1, String string2, int index, int length){

         if (string1 == null || string2 == null) {
             return false;
         }

         if (index < 0 || length < 0) {
             return false;
         }

         //проверка фрагмент не выходит за пределы обеих строк
         if (index + length > string1.length() || index + length > string2.length()) {
             return false;
         }

         //извлечение подстроки и сравнение
         return string1.substring(index, index + length).equals(string2.substring(index, index + length));
    }

    //21 Возвращает true, если после замены в string1 всех вхождений replaceInStr1 на replaceByInStr1
    // и замены в string2 всех вхождений replaceInStr2 на replaceByInStr2 полученные строки равны.
    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1,
                                                        String string2, char replaceInStr2, char replaceByInStr2){
        if (string1 == null || string2 == null) {
            return false;
        }

        //замена символов в стр1
        String modifiedString1 = string1.replace(replaceInStr1, replaceByInStr1);

        //замена символов в стр2
        String modifiedString2 = string2.replace(replaceInStr2, replaceByInStr2);

        //сравнение строк
        return modifiedString1.equals(modifiedString2);
    }


    //22 Возвращает true, если после замены в string1 всех вхождений строки replceInStr1
    // на replaceByInStr1 и замены в string2 всех вхождений replceInStr2 на replaceByInStr2 полученные строки равны.
     public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1,
                                                            String string2, String replaceInStr2, String replaceByInStr2){

         if (string1 == null || string2 == null) {
             return false;
         }

         //проверка замены на null
         if (replaceInStr1 == null || replaceByInStr1 == null ||
                 replaceInStr2 == null || replaceByInStr2 == null) {
             return false;
         }

         //замена подстрок
         String modifiedString1 = string1.replace(replaceInStr1, replaceByInStr1);
         String modifiedString2 = string2.replace(replaceInStr2, replaceByInStr2);

         return modifiedString1.equals(modifiedString2);
    }

    //23 Возвращает true, если строка после выбрасывания из нее всех пробелов является палиндромом, без учета регистра.
    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string){

        if (string == null) {
            return false;
        }

        //удаление всех пробелов
        String stringWithoutSpaces = string.replace(" ", "");

        //переворот
        String reversed = new StringBuilder(stringWithoutSpaces).reverse().toString();

        //сравнение без учета регистра
        return stringWithoutSpaces.equalsIgnoreCase(reversed);
    }

    //24 Возвращает true, если две строки равны, если не принимать во внимание все пробелы в начале и конце каждой строки.
    public static boolean isEqualAfterTrimming(String string1, String string2){

        if (string1 == null || string2 == null) {
            return false;
        }

        //удаление пробелов в начале и конце строк
        String trimmed1 = string1.trim();
        String trimmed2 = string2.trim();

        return trimmed1.equals(trimmed2);
    }

    //25 Для заданного массива целых чисел создает текстовую строку,
    // в которой числа разделены знаком “запятая” (т.н. формат CSV - comma separated values).
    //Для пустого массива возвращается пустая строка.
    public static String makeCsvStringFromInts(int[] array){

        if (array == null || array.length == 0) {
            return "";
        }

        //создание строки через StringBuilder
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(",");
            }
        }

        return result.toString();
    }

    //26 Для заданного массива вещественных чисел создает текстовую строку, в которой числа разделены знаком “запятая”,
    //причем каждое число записывается с двумя знаками после точки. Для пустого массива возвращается пустая строка.
    public static String makeCsvStringFromDoubles(double[] array){
        if (array == null || array.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            //форматирование числа с двумя знаками после запятой
            result.append(String.format("%.2f", array[i]));
            if (i < array.length - 1) {
                result.append(",");
            }
        }

        return result.toString();
    }

    //27 То же, что и в упражнении 25, но возвращает StringBuilder.
    public static StringBuilder makeCsvStringBuilderFromInts(int[] array){
        if (array == null || array.length == 0) {
            return new StringBuilder(); // возврат пустой StringBuilder
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(",");
            }
        }

        return result;
    }

    //28 То же, что и в упражнении 26, но возвращает StringBuilder.
    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array){
        if (array == null || array.length == 0) {
            return new StringBuilder();
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            result.append(String.format("%.2f", array[i]));
            if (i < array.length - 1) {
                result.append(",");
            }
        }

        return result;
    }

    //29 Удаляет из строки символы, номера которых заданы в массиве positions.
    //Предполагается, что будут передаваться только допустимые номера, упорядоченные по возрастанию.
    //Номера позиций для удаления указаны для исходной строки. Возвращает полученный в результате StringBuilder.
	 public static StringBuilder removeCharacters(String string, int[] positions){
         if (string == null || positions == null) {
             return new StringBuilder();
         }

         StringBuilder result = new StringBuilder(string);

         //удаление с конца
         for (int i = positions.length - 1; i >= 0; i--) {
             result.deleteCharAt(positions[i]);
         }

         return result;
     }

     //30 Вставляет в строку символы. Массивы positions и characters имеют одинаковую длину.
    //В позицию positions[i] в исходной строке string вставляется символ characters[i].
    //Если в массиве positions один и тот же номер позиции повторяется несколько раз, это значит,
     // что в указанную позицию вставляется несколько символов,  в том порядке, в котором они перечислены в массиве characters.
    //Предполагается, что будут передаваться только допустимые номера, упорядоченные по неубыванию.  Возвращает полученный в результате StringBuilder.
	 public static StringBuilder insertCharacters(String string, int[] positions, char[] characters){
         if (string == null || positions == null || characters == null) {
             return new StringBuilder();
         }

         StringBuilder result = new StringBuilder(string);

         //вставка символов с учетом возможных повторяющихся позиций
         for (int i = 0; i < positions.length; i++) {
             //корректировка позиции с учетом ранее вставленных символов
             int adjustedPosition = positions[i];
             for (int j = 0; j < i; j++) {
                 if (positions[j] <= positions[i]) {
                     adjustedPosition++;
                 }
             }
             result.insert(adjustedPosition, characters[i]);
         }

         return result;
     }
}
