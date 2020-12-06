package com.epam.jbmp.counter;

import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class WordFrequencyForkJoinCounter extends RecursiveTask<List<Pair<String, Long>>> {
    private static final int THRESHOLD = 3;

    private final List<String> words;
    private final int wordsSize;

    public WordFrequencyForkJoinCounter(List<String> words) {
        this.words = words;
        this.wordsSize = words.size();
    }

    @Override
    protected List<Pair<String, Long>> compute() {
        if (wordsSize < THRESHOLD) {
            return add();
        }
        WordFrequencyForkJoinCounter firstTask = new WordFrequencyForkJoinCounter(words.subList(0, wordsSize / 2));
        firstTask.fork();
        WordFrequencyForkJoinCounter secondTask = new WordFrequencyForkJoinCounter(words.subList(wordsSize / 2, wordsSize));
        List<Pair<String, Long>> secondTaskResult = secondTask.compute();
        List<Pair<String, Long>> firstTaskResult = firstTask.join();
        return merge(firstTaskResult, secondTaskResult);
    }

    private List<Pair<String, Long>> add() {
        List<Pair<String, Long>> frequentWords = new ArrayList<>();
        for (String word : words) {
            int index = getPairIndexByKey(frequentWords, word);
            if (index == StringUtils.INDEX_NOT_FOUND) {
                frequentWords.add(new Pair<>(word, 1L));
            } else {
                long newPairValue = frequentWords.get(index).getValue() + 1L;
                frequentWords.set(index, new Pair<>(word, newPairValue));
            }
        }
        return frequentWords;
    }

    private List<Pair<String, Long>> merge(List<Pair<String, Long>> leftPart, List<Pair<String, Long>> rightPart) {
        for (Pair<String, Long> pair : rightPart) {
            String word = pair.getKey();
            int index = getPairIndexByKey(leftPart, word);
            if (index == StringUtils.INDEX_NOT_FOUND) {
                leftPart.add(new Pair<>(word, 1L));
            } else {
                long leftPartValue = leftPart.get(index).getValue();
                long rightPartValue = pair.getValue();
                leftPart.set(index, new Pair<>(word, Math.max(leftPartValue, rightPartValue) + 1L));
            }
        }
        return leftPart;
    }

    private int getPairIndexByKey(List<Pair<String, Long>> frequentTable, String candidate) {
        for (int i = 0; i < frequentTable.size(); i++) {
            if (frequentTable.get(i).getKey().equals(candidate)) {
                return i;
            }
        }
        return StringUtils.INDEX_NOT_FOUND;
    }
}
