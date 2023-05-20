package javapro.dz12;

import java.util.*;

public class OccCalculator {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("aaa", "bbb", "ccc", "aaa", "ddd", "ccc", "aaa");
        calcOccurrence(wordList);
    }

    public static void calcOccurrence(List<String> wordList) {
        Map<String, Integer> occurrenceMap = new HashMap<>();

        for (String word : wordList) {
            if (occurrenceMap.containsKey(word)) {
                occurrenceMap.put(word, occurrenceMap.get(word) + 1);
            } else {
                occurrenceMap.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
