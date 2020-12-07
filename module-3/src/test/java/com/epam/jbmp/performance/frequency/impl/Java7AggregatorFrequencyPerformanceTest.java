package com.epam.jbmp.performance.frequency.impl;

import com.epam.jbmp.Java7Aggregator;
import com.epam.jbmp.performance.frequency.JavaAggregatorFrequencyPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7AggregatorFrequencyPerformanceTest extends JavaAggregatorFrequencyPerformanceTest {

    public Java7AggregatorFrequencyPerformanceTest() {
        super(new Java7Aggregator());
        System.out.print("Java 7 Aggregator Frequency Performance Test (ms): ");
    }

}
