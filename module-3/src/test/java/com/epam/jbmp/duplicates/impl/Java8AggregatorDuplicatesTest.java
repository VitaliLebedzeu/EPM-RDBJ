package com.epam.jbmp.duplicates.impl;

import com.epam.jbmp.Java8Aggregator;
import com.epam.jbmp.duplicates.JavaAggregatorDuplicatesTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java8AggregatorDuplicatesTest extends JavaAggregatorDuplicatesTest {

    public Java8AggregatorDuplicatesTest() {
        super(new Java8Aggregator());
    }
}

