package com.epam.jbmp.duplicates.impl;

import com.epam.jbmp.Java7Aggregator;
import com.epam.jbmp.duplicates.JavaAggregatorDuplicatesTest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Java7AggregatorDuplicatesTest extends JavaAggregatorDuplicatesTest {

    public Java7AggregatorDuplicatesTest() {
        super(new Java7Aggregator());
    }
}
