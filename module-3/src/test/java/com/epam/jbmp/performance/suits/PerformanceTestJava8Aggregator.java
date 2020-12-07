package com.epam.jbmp.performance.suits;

import com.epam.jbmp.duplicates.impl.Java8AggregatorDuplicatesTest;
import com.epam.jbmp.frequency.impl.Java8AggregatorFrequencyTest;
import com.epam.jbmp.performance.sum.impl.Java8AggregatorSumPerformanceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java8AggregatorFrequencyTest.class,
        Java8AggregatorSumPerformanceTest.class,
        Java8AggregatorDuplicatesTest.class,
})
public class PerformanceTestJava8Aggregator {
}
