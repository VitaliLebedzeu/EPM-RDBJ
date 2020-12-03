package com.epam.jbmp.sum.impl;

import com.epam.jbmp.Java8Aggregator;
import com.epam.jbmp.sum.JavaAggregatorSumTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8AggregatorSumTest extends JavaAggregatorSumTest {

    public Java8AggregatorSumTest() {
        super(new Java8Aggregator());
    }
}

