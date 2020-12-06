package com.epam.jbmp.counter;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DuplicatesForkJoinCounter extends RecursiveTask<List<String>> {
    private static final int THRESHOLD = 3;

    private final List<Pair<String, Integer>> wordFrequencyTable;
    private final int wordFrequencyTableSize;

    public DuplicatesForkJoinCounter(List<Pair<String, Integer>> wordFrequencyTable) {
        this.wordFrequencyTable = wordFrequencyTable;
        this.wordFrequencyTableSize = wordFrequencyTable.size();
    }

    @Override
    protected List<String> compute() {
        if (wordFrequencyTableSize < THRESHOLD) {
            return add();
        }
        DuplicatesForkJoinCounter firstTask = new DuplicatesForkJoinCounter(wordFrequencyTable.subList(0, wordFrequencyTableSize / 2));
        firstTask.fork();
        DuplicatesForkJoinCounter secondTask = new DuplicatesForkJoinCounter(wordFrequencyTable.subList(wordFrequencyTableSize / 2, wordFrequencyTableSize));
        List<String> secondTaskResult = secondTask.compute();
        List<String> firstTaskResult = firstTask.join();
        firstTaskResult.addAll(secondTaskResult);
        return firstTaskResult;
    }

    private List<String> add() {
        List<String> duplicates = new ArrayList<>();
        for (Pair<String, Integer> pair : wordFrequencyTable) {
            if (pair.getValue() > 1) {
                duplicates.add(pair.getKey());
            }
        }
        return duplicates;
    }
}
