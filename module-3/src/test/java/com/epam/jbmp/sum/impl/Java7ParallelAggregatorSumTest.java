package com.epam.jbmp.sum.impl;

import com.epam.jbmp.Java7ParallelAggregator;
import com.epam.jbmp.sum.JavaAggregatorSumTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorSumTest extends JavaAggregatorSumTest {

    public Java7ParallelAggregatorSumTest() {
        super(new Java7ParallelAggregator());
    }
}
