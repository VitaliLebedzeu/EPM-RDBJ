package com.epam.jbmp.duplicates.impl;

import com.epam.jbmp.Java7ParallelAggregator;
import com.epam.jbmp.duplicates.JavaAggregatorDuplicatesTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7ParallelAggregatorDuplicatesTest extends JavaAggregatorDuplicatesTest {

    public Java7ParallelAggregatorDuplicatesTest() {
        super(new Java7ParallelAggregator());
    }
}
