package com.epam.jbmp.suits;

import com.epam.jbmp.duplicates.impl.Java8AggregatorDuplicatesTest;
import com.epam.jbmp.frequency.impl.Java8AggregatorFrequencyTest;
import com.epam.jbmp.sum.impl.Java8AggregatorSumTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Java8AggregatorFrequencyTest.class,
        Java8AggregatorSumTest.class,
        Java8AggregatorDuplicatesTest.class,
})
public class TestJava8Aggregator {
}
