package com.epam.jbmp.suits;

import com.epam.jbmp.duplicates.impl.Java7AggregatorDuplicatesTest;
import com.epam.jbmp.frequency.impl.Java7AggregatorFrequencyTest;
import com.epam.jbmp.sum.impl.Java7AggregatorSumTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java7AggregatorFrequencyTest.class,
        Java7AggregatorSumTest.class,
        Java7AggregatorDuplicatesTest.class,
})
public class TestJava7Aggregator {
}
