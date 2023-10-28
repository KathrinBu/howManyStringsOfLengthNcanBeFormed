
/*
Дано число n, задача — посчитать, сколько сочетаний длины n можно сформировать по следующим правилам:
Каждый символ представляет собой строчную гласную ( 'a', 'e', 'i', 'o', 'u')
За каждой гласной  'a' может следовать только 'e'.
За каждой гласной  'e' может следовать только символ 'a' или 'i'.
За каждой гласной  'i' не может следовать другая 'i'.
За каждой гласной  'o' может следовать только 'i'или 'u'.
За каждой гласной  'u' может следовать только 'a'.
Поскольку ответ может быть слишком большим, верните его по модулю 10^9 + 7.
===Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
===Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
===Example 3:
Input: n = 5
Output: 68
 */

public class Main {
    public static void main(String[] args) {
     int n=5;
        int count = countCombinations(n);

        System.out.println("Количество сочетаний длины " + n + ": " + count);
    }

    public static int countCombinations(int n) {
        return countCombinationsHelper(n, ' ');
    }

    private static int countCombinationsHelper(int n, char prevChar) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char vowel : vowels) {
            if (isValidCombination(prevChar, vowel)) {
                count += countCombinationsHelper(n - 1, vowel); //Если комбинация допустима, мы увеличиваем счетчик
                // count и рекурсивно вызываем countCombinationsHelper() для проверки следующего символа.
            }
        }

        return count;
    }

    private static boolean isValidCombination(char prevChar, char currChar) {
        if (prevChar == 'a') {
            return currChar == 'e';
        } else if (prevChar == 'e') {
            return currChar == 'a' || currChar == 'i';
        } else if (prevChar == 'i') {
            return currChar == 'a' || currChar == 'e' || currChar == 'o' || currChar == 'u';
        } else if (prevChar == 'o') {
            return currChar == 'i' || currChar == 'u';
        } else if (prevChar == 'u') {
            return currChar == 'a';
        }

        return true;
    }
}
