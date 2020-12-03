package com.epam.jbmp.frequency.impl;

import com.epam.jbmp.Java7ParallelAggregator;
import com.epam.jbmp.frequency.JavaAggregatorFrequencyTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorFrequencyTest extends JavaAggregatorFrequencyTest {

    public Java7ParallelAggregatorFrequencyTest() {
        super(new Java7ParallelAggregator());
    }
}
