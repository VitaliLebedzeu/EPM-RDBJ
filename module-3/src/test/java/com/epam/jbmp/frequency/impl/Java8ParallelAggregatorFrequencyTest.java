package com.epam.jbmp.frequency.impl;

import com.epam.jbmp.Java8ParallelAggregator;
import com.epam.jbmp.frequency.JavaAggregatorFrequencyTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8ParallelAggregatorFrequencyTest extends JavaAggregatorFrequencyTest {

    public Java8ParallelAggregatorFrequencyTest() {
        super(new Java8ParallelAggregator());
    }
}
