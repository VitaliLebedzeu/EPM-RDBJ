package com.epam.jbmp.suits;

import com.epam.jbmp.duplicates.impl.Java7ParallelAggregatorDuplicatesTest;
import com.epam.jbmp.frequency.impl.Java7ParallelAggregatorFrequencyTest;
import com.epam.jbmp.sum.impl.Java7ParallelAggregatorSumTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java7ParallelAggregatorFrequencyTest.class,
        Java7ParallelAggregatorSumTest.class,
        Java7ParallelAggregatorDuplicatesTest.class,
})
public class TestJava7ParallelAggregator {
}
