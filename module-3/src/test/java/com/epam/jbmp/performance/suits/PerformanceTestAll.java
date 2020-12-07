package com.epam.jbmp.performance.suits;

import com.epam.jbmp.performance.duplicates.impl.Java7AggregatorDuplicatesPerformanceTest;
import com.epam.jbmp.performance.duplicates.impl.Java7ParallelAggregatorDuplicatesPerformanceTest;
import com.epam.jbmp.performance.duplicates.impl.Java8AggregatorDuplicatesPerformanceTest;
import com.epam.jbmp.performance.duplicates.impl.Java8ParallelAggregatorDuplicatesPerformanceTest;
import com.epam.jbmp.performance.frequency.impl.Java7AggregatorFrequencyPerformanceTest;
import com.epam.jbmp.performance.frequency.impl.Java7ParallelAggregatorFrequencyPerformanceTest;
import com.epam.jbmp.performance.frequency.impl.Java8AggregatorFrequencyPerformanceTest;
import com.epam.jbmp.performance.frequency.impl.Java8ParallelAggregatorFrequencyPerformanceTest;
import com.epam.jbmp.performance.sum.impl.Java7AggregatorSumPerformanceTest;
import com.epam.jbmp.performance.sum.impl.Java7ParallelAggregatorSumPerformanceTest;
import com.epam.jbmp.performance.sum.impl.Java8AggregatorSumPerformanceTest;
import com.epam.jbmp.performance.sum.impl.Java8ParallelAggregatorSumPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java7AggregatorFrequencyPerformanceTest.class,
        Java7AggregatorSumPerformanceTest.class,
        Java7AggregatorDuplicatesPerformanceTest.class,

        Java8AggregatorFrequencyPerformanceTest.class,
        Java8AggregatorSumPerformanceTest.class,
        Java8AggregatorDuplicatesPerformanceTest.class,

        Java7ParallelAggregatorFrequencyPerformanceTest.class,
        Java7ParallelAggregatorSumPerformanceTest.class,
        Java7ParallelAggregatorDuplicatesPerformanceTest.class,

        Java8ParallelAggregatorFrequencyPerformanceTest.class,
        Java8ParallelAggregatorSumPerformanceTest.class,
        Java8ParallelAggregatorDuplicatesPerformanceTest.class,
})
public class PerformanceTestAll {
}
