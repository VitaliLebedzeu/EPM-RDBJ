package com.epam.jbmp;

import com.epam.jbmp.comparator.PairDecreaseComparatorByValueAndAlphabeticallyOrder;
import com.epam.jbmp.comparator.StringIncreaseComparatorByLengthAndAlphabeticallyOrder;
import com.epam.jbmp.counter.DuplicatesForkJoinCounter;
import com.epam.jbmp.counter.WordFrequencyForkJoinCounter;
import com.epam.jbmp.counter.NumbersSumForkJoinCounter;

import com.epam.jbmp.counter.WordFrequencyIgnoreCaseForkJoinCounter;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Java7ParallelAggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        return new ForkJoinPool(4).invoke(new NumbersSumForkJoinCounter(numbers));
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        List<Pair<String, Long>> mostFrequentWords = new ForkJoinPool().invoke(new WordFrequencyForkJoinCounter(words));
        Collections.sort(mostFrequentWords, new PairDecreaseComparatorByValueAndAlphabeticallyOrder());
        return (mostFrequentWords.size() > limit) ? mostFrequentWords.subList(0, (int) limit) : mostFrequentWords;
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        List<Pair<String, Integer>> wordFrequencyTable = new ForkJoinPool().invoke(new WordFrequencyIgnoreCaseForkJoinCounter(words));
        List<String> duplicates = new ForkJoinPool().invoke(new DuplicatesForkJoinCounter(wordFrequencyTable));
        Collections.sort(duplicates, new StringIncreaseComparatorByLengthAndAlphabeticallyOrder());
        return (duplicates.size() > limit) ? duplicates.subList(0, (int) limit) : duplicates;

    }
}
