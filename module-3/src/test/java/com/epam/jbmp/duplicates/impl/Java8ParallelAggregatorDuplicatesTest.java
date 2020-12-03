package com.epam.jbmp.duplicates.impl;

import com.epam.jbmp.Java8ParallelAggregator;
import com.epam.jbmp.duplicates.JavaAggregatorDuplicatesTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8ParallelAggregatorDuplicatesTest extends JavaAggregatorDuplicatesTest {

    public Java8ParallelAggregatorDuplicatesTest() {
        super(new Java8ParallelAggregator());
    }

}
