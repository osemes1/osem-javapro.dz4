package javapro.dz7;

import java.util.Random;
import java.util.Scanner;

public class StringLearning {
    public static int findSymbolOccurance(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    public static int findWordPosition(String source, String target) {
        if (source.contains(target)) {
            return source.indexOf(target);
        }
        return -1;
    }

    public static String stringReverse(String str) {
        StringBuilder reversedString = new StringBuilder(str);
        reversedString.reverse();
        return reversedString.toString();
    }

    public static boolean isPalindrome(String str) {
        String reversedString = stringReverse(str);
        return str.equals(reversedString);
    }

    public static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int index = random.nextInt(words.length);
        String word = words[index];
        String hiddenWord = word.replaceAll("a", "###");
//        String hiddenWord = word.replaceAll(".", "#"); тоді у питанні буде #######
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(String.format("Вгадай слово: %s",hiddenWord));
            String input = scanner.nextLine().toLowerCase();
            if (input.equals(word)) {
                System.out.println("Ви відгадали!");
                break;
            } else {
                StringBuilder sb = new StringBuilder(hiddenWord);
                for (int i = 0; i < input.length() && i < word.length(); i++) {
                    if (input.charAt(i) == word.charAt(i)) {
                        sb.setCharAt(i, input.charAt(i));
                    }
                }
                hiddenWord = sb.toString();
            }
        }
    }
}
