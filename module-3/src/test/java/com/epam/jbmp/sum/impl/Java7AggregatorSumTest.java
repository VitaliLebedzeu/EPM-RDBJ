package com.epam.jbmp.sum.impl;

import com.epam.jbmp.Java7Aggregator;
import com.epam.jbmp.sum.JavaAggregatorSumTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7AggregatorSumTest extends JavaAggregatorSumTest {

    public Java7AggregatorSumTest() {
        super(new Java7Aggregator());
    }

}
