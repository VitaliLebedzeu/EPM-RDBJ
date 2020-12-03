package com.epam.jbmp.frequency.impl;

import com.epam.jbmp.Java8Aggregator;
import com.epam.jbmp.frequency.JavaAggregatorFrequencyTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8AggregatorFrequencyTest extends JavaAggregatorFrequencyTest {

    public Java8AggregatorFrequencyTest() {
        super(new Java8Aggregator());
    }
}

