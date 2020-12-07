package com.epam.jbmp.performance.frequency.impl;

import com.epam.jbmp.Java8Aggregator;
import com.epam.jbmp.performance.frequency.JavaAggregatorFrequencyPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8AggregatorFrequencyPerformanceTest extends JavaAggregatorFrequencyPerformanceTest {

    public Java8AggregatorFrequencyPerformanceTest() {
        super(new Java8Aggregator());
        System.out.print("Java 8 Aggregator Frequency Performance Test (ms): ");
    }
}

