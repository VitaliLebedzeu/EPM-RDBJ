package com.epam.jbmp;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8ParallelAggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        return numbers.parallelStream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        Map<String, Long> frequentWordsTable = words.parallelStream().collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        List<Pair<String, Long>> frequentWords = frequentWordsTable.entrySet().parallelStream().map(e -> new Pair<>(e.getKey(), e.getValue()))
                                                                   .sorted((p1, p2) ->
                                                                           (p1.getKey().length() == p2.getKey().length())
                                                                                   ? p1.getKey().compareTo(p2.getKey())
                                                                                   : (int) (p2.getValue() - p1.getValue()))
                                                                   .collect(Collectors.toList());
        return (frequentWords.size() < limit) ? frequentWords : frequentWords.subList(0, (int) limit);
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        Map<String, Long> wordFrequency = words.parallelStream().map(String::toUpperCase)
                                               .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        List<String> duplicates = wordFrequency.entrySet().parallelStream().filter(p -> p.getValue() > 1).map(Map.Entry::getKey)
                                               .sorted((s1, s2) -> (s1.length() == s2.length()) ? s1.compareTo(s2) : s1.length() - s2.length())
                                               .collect(Collectors.toList());
        return (duplicates.size() < limit) ? duplicates : duplicates.subList(0, (int) limit);
    }
}
