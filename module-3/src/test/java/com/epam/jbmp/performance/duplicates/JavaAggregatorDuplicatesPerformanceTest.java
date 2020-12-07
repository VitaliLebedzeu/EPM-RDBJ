package com.epam.jbmp.performance.duplicates;

import com.epam.jbmp.Aggregator;
import com.epam.jbmp.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public abstract class JavaAggregatorDuplicatesPerformanceTest {

    @Parameterized.Parameter()
    public long limit;

    @Parameterized.Parameter(1)
    public List<String> words;

    @Parameterized.Parameter(2)
    public List<String> expected;

    private final Aggregator aggregator;

    public JavaAggregatorDuplicatesPerformanceTest(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{20, Util.getWordsForDuplicates(), getExpected()});
        return data;
    }

    @Test
    public void test() {
        final long then = System.nanoTime();
        List<String> actual = aggregator.getDuplicates(words, limit);
        assertEquals(expected, actual);
        final long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - then);
        System.out.println(StringUtils.SPACE + millis);
    }

    private static List<String> getExpected() {
        return Arrays.asList("F", "G", "H", "I", "J");
    }

}
