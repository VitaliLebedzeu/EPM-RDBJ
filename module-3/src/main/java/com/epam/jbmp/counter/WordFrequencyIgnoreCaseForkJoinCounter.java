package com.epam.jbmp.counter;

import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class WordFrequencyIgnoreCaseForkJoinCounter extends RecursiveTask<List<Pair<String, Integer>>> {
    private static final int THRESHOLD = 3;

    private final List<String> words;
    private final int wordsSize;

    public WordFrequencyIgnoreCaseForkJoinCounter(List<String> words) {
        this.words = words;
        this.wordsSize = words.size();
    }

    @Override
    protected List<Pair<String, Integer>> compute() {
        if (wordsSize < THRESHOLD) {
            return add();
        } else {
            WordFrequencyIgnoreCaseForkJoinCounter firstTask = new WordFrequencyIgnoreCaseForkJoinCounter(words.subList(0, wordsSize / 2));
            firstTask.fork();
            WordFrequencyIgnoreCaseForkJoinCounter secondTask = new WordFrequencyIgnoreCaseForkJoinCounter(words.subList(wordsSize / 2, wordsSize));
            List<Pair<String, Integer>> secondTaskResult = secondTask.compute();
            List<Pair<String, Integer>> firstTaskResult = firstTask.join();
            return merge(firstTaskResult, secondTaskResult);
        }
    }

    private List<Pair<String, Integer>> add() {
        List<Pair<String, Integer>> frequentWordsTable = new ArrayList<>();
        for (String word : words) {
            String candidate = word.toUpperCase();
            int index = getPairIndexByKey(frequentWordsTable, candidate);
            if (index == StringUtils.INDEX_NOT_FOUND) {
                frequentWordsTable.add(new Pair<>(candidate, 1));
            } else {
                int newPairValue = frequentWordsTable.get(index).getValue() + 1;
                frequentWordsTable.set(index, new Pair<>(candidate, newPairValue));
            }
        }
        return frequentWordsTable;
    }

    private List<Pair<String, Integer>> merge(List<Pair<String, Integer>> leftPart, List<Pair<String, Integer>> rightPart) {
        for (Pair<String, Integer> pair : rightPart) {
            String word = pair.getKey();
            int currentValue = pair.getValue();
            int index = getPairIndexByKey(leftPart, word);
            if (index == StringUtils.INDEX_NOT_FOUND) {
                leftPart.add(new Pair<>(word, currentValue));
            } else {
                int leftPartValue = leftPart.get(index).getValue();
                leftPart.set(index, new Pair<>(word, Math.max(leftPartValue, currentValue) + 1));
            }
        }
        return leftPart;
    }

    private int getPairIndexByKey(List<Pair<String, Integer>> frequentTable, String candidate) {
        for (int i = 0; i < frequentTable.size(); i++) {
            if (frequentTable.get(i).getKey().equals(candidate)) {
                return i;
            }
        }
        return StringUtils.INDEX_NOT_FOUND;
    }
}
