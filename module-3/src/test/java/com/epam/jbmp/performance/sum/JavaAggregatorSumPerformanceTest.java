package com.epam.jbmp.performance.sum;

import com.epam.jbmp.Aggregator;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public abstract class JavaAggregatorSumPerformanceTest {

    @Parameterized.Parameter()
    public List<Integer> numbers;

    @Parameterized.Parameter(1)
    public int expected;

    private final Aggregator aggregator;

    public JavaAggregatorSumPerformanceTest(Aggregator aggregator) {
        this.aggregator = aggregator;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{getNumbersList(), 1783293664});
        return data;

    }

    @Test
    public void test() {
        final long then = System.nanoTime();
        int actual = aggregator.sum(numbers);
        assertEquals(expected, actual);
        final long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - then);
        System.out.println(StringUtils.SPACE + millis);
    }

    private static List<Integer> getNumbersList() {
        return IntStream.range(0, 1_000_000).boxed().collect(Collectors.toList());
    }
}
