package com.epam.jbmp.sum.impl;

import com.epam.jbmp.Java8ParallelAggregator;
import com.epam.jbmp.sum.JavaAggregatorSumTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8ParallelAggregatorSumTest extends JavaAggregatorSumTest {

    public Java8ParallelAggregatorSumTest() {
        super(new Java8ParallelAggregator());
    }
}
