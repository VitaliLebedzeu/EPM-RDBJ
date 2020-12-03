package com.epam.jbmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;

import org.apache.commons.lang3.StringUtils;

public class Java7Aggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        List<Pair<String, Long>> mostFrequentWords = new ArrayList<>();
        for (String word : words) {
            int index = getPairIndexByKey(mostFrequentWords, word);
            if (index == StringUtils.INDEX_NOT_FOUND) {
                mostFrequentWords.add(new Pair<>(word, 1L));
            } else {
                long newPairValue = mostFrequentWords.get(index).getValue() + 1L;
                mostFrequentWords.set(index, new Pair<>(word, newPairValue));
            }
        }
        Collections.sort(mostFrequentWords, new PairDecreaseComparatorByValueAndAlphabeticallyOrder());
        return (mostFrequentWords.size() > limit) ? mostFrequentWords.subList(0, (int) limit) : mostFrequentWords;
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        List<String> duplicates = new ArrayList<>();
        int wordsSize = words.size();
        for (int i = 0; i < wordsSize; i++) {
            String word = words.get(i);
            if (stringListNotContainsIgnoreCase(duplicates, word)) {
                if (stringListContainsIgnoreCase(words.subList(i + 1, wordsSize), word)) {
                    duplicates.add(word.toUpperCase());
                }
            }
        }
        Collections.sort(duplicates, new StringIncreaseComparatorByLengthAndAlphabeticallyOrder());
        return (duplicates.size() > limit) ? duplicates.subList(0, (int) limit) : duplicates;
    }

    private int getPairIndexByKey(List<Pair<String, Long>> frequentTable, String candidate) {
        for (int i = 0; i < frequentTable.size(); i++) {
            if (frequentTable.get(i).getKey().equals(candidate)) {
                return i;
            }
        }
        return StringUtils.INDEX_NOT_FOUND;
    }

    private boolean stringListNotContainsIgnoreCase(List<String> words, String candidate) {
        return !stringListContainsIgnoreCase(words, candidate);
    }

    private boolean stringListContainsIgnoreCase(List<String> words, String candidate) {
        for (String word : words) {
            if (word.equalsIgnoreCase(candidate)) {
                return true;
            }
        }
        return false;
    }

    private static class PairDecreaseComparatorByValueAndAlphabeticallyOrder implements Comparator<Pair<String, Long>> {

        @Override
        public int compare(Pair<String, Long> p1, Pair<String, Long> p2) {
            String pairKey1 = p1.getKey();
            String pairKey2 = p2.getKey();
            return (pairKey1.length() == pairKey2.length()) ? pairKey1.compareTo(pairKey2) : (int) (p1.getValue() - p2.getValue());
        }
    }

    private static class StringIncreaseComparatorByLengthAndAlphabeticallyOrder implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            int length1 = s1.length();
            int length2 = s2.length();
            return (length1 == length2) ? s1.compareTo(s2) : length1 - length2;
        }
    }
}
