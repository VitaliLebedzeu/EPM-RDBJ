package com.epam.jbmp.performance.suits;

import com.epam.jbmp.duplicates.impl.Java7ParallelAggregatorDuplicatesTest;
import com.epam.jbmp.frequency.impl.Java7ParallelAggregatorFrequencyTest;
import com.epam.jbmp.performance.sum.impl.Java7ParallelAggregatorSumPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java7ParallelAggregatorFrequencyTest.class,
        Java7ParallelAggregatorSumPerformanceTest.class,
        Java7ParallelAggregatorDuplicatesTest.class,
})
public class PerformanceTestJava7ParallelAggregator {
}
