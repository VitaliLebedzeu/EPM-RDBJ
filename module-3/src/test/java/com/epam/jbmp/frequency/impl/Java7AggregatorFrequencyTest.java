package com.epam.jbmp.frequency.impl;

import com.epam.jbmp.Java7Aggregator;
import com.epam.jbmp.frequency.JavaAggregatorFrequencyTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7AggregatorFrequencyTest extends JavaAggregatorFrequencyTest {

    public Java7AggregatorFrequencyTest() {
        super(new Java7Aggregator());
    }

}
