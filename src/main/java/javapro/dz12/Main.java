package javapro.dz12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    // Метод countOccurance
    public static int countOccurance(List<String> wordList, String targetWord) {
        int count = 0;
        for (String word : wordList) {
            if (word.equals(targetWord)) {
                count++;
            }
        }
        return count;
    }

    // Метод toList
    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

    // Метод findUnique
    public static List<Integer> findUnique(List<Integer> numberList) {
        Set<Integer> uniqueSet = new HashSet<>(numberList);
        List<Integer> uniqueList = new ArrayList<>(uniqueSet);
        return uniqueList;
    }

    public static void main(String[] args) {
        // Приклади використання

        // Метод countOccurance
        List<String> words = new ArrayList<>();
        words.add("папуга");
        words.add("їжачок");
        words.add("черепаха");
        words.add("білка");
        words.add("папуга");
        words.add("папуга");
        String target = "папуга";
        int occurrences = countOccurance(words, target);
        System.out.println("слово '" + target + "' містить " + occurrences + " раз(рази)");

        // Метод toList
        int[] array = {1, 2, 3};
        List<Integer> convertedList = toList(array);
        System.out.println(convertedList);

        // Метод findUnique
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        numbers.add(4);
        numbers.add(5);
        List<Integer> uniqueNumbers = findUnique(numbers);
        System.out.println(uniqueNumbers);
    }
}
