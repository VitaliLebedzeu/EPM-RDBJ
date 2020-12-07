package com.epam.jbmp.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {

    public static List<String> getWordsForFrequency() {
        List<String> words = IntStream.rangeClosed(65, 90).mapToObj(c -> (char) c).map(String::valueOf).collect(Collectors.toList());
        words.addAll(words.subList(5, 15).stream().map(String::toLowerCase).collect(Collectors.toList()));
        words.addAll(words.subList(20, 30));
        words.addAll(words.subList(10, 25).stream().map(String::toLowerCase).collect(Collectors.toList()));
        words.addAll(words.subList(14, 22));
        return words;
    }

    public static List<String> getWordsForDuplicates() {
        List<String> words = IntStream.rangeClosed(65, 90).mapToObj(c -> (char) c).map(String::valueOf).collect(Collectors.toList());
        words.addAll(words.subList(5, 7).stream().map(String::toLowerCase).collect(Collectors.toList()));
        words.addAll(words.subList(7, 8));
        words.addAll(words.subList(6, 7).stream().map(String::toLowerCase).collect(Collectors.toList()));
        words.addAll(words.subList(8, 10));
        return words;
    }
}
