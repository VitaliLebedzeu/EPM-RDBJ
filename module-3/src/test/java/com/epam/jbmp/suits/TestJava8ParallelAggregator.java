package com.epam.jbmp.suits;

import com.epam.jbmp.duplicates.impl.Java8ParallelAggregatorDuplicatesTest;
import com.epam.jbmp.frequency.impl.Java8ParallelAggregatorFrequencyTest;
import com.epam.jbmp.sum.impl.Java8ParallelAggregatorSumTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java8ParallelAggregatorFrequencyTest.class,
        Java8ParallelAggregatorSumTest.class,
        Java8ParallelAggregatorDuplicatesTest.class,
})
public class TestJava8ParallelAggregator {
}
