package com.epam.jbmp.performance.frequency;

import com.epam.jbmp.Aggregator;
import com.epam.jbmp.util.Util;
import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public abstract class JavaAggregatorFrequencyPerformanceTest {

    @Parameterized.Parameter()
    public long limit;

    @Parameterized.Parameter(1)
    public List<String> words;

    @Parameterized.Parameter(2)
    public List<Pair<String, Long>> expected;

    private final Aggregator aggregator;

    public JavaAggregatorFrequencyPerformanceTest(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{6, Util.getWordsForFrequency(),
                asList(new Pair<>("U", 3L), new Pair<>("V", 3L), new Pair<>("O", 2L), new Pair<>("P", 2L), new Pair<>("Q", 2L), new Pair<>("R", 2L))});
        return data;
    }
    @Test
    public void test() {
        final long then = System.nanoTime();
        List<Pair<String, Long>> actual = aggregator.getMostFrequentWords(words, limit);
        assertEquals(expected, actual);
        final long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - then);
        System.out.println(StringUtils.SPACE + millis);
    }
}
