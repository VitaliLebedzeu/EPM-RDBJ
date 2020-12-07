package com.epam.jbmp.performance.suits;

import com.epam.jbmp.duplicates.impl.Java8ParallelAggregatorDuplicatesTest;
import com.epam.jbmp.frequency.impl.Java8ParallelAggregatorFrequencyTest;
import com.epam.jbmp.performance.sum.impl.Java8ParallelAggregatorSumPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java8ParallelAggregatorFrequencyTest.class,
        Java8ParallelAggregatorSumPerformanceTest.class,
        Java8ParallelAggregatorDuplicatesTest.class,
})
public class PerformanceTestJava8ParallelAggregator {
}
