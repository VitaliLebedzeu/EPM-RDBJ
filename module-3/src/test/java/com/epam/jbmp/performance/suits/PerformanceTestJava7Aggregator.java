package com.epam.jbmp.performance.suits;

import com.epam.jbmp.duplicates.impl.Java7AggregatorDuplicatesTest;
import com.epam.jbmp.frequency.impl.Java7AggregatorFrequencyTest;
import com.epam.jbmp.performance.sum.impl.Java7AggregatorSumPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java7AggregatorFrequencyTest.class,
        Java7AggregatorSumPerformanceTest.class,
        Java7AggregatorDuplicatesTest.class,
})
public class PerformanceTestJava7Aggregator {
}
