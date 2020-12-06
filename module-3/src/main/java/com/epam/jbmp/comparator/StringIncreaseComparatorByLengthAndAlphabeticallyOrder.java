package com.epam.jbmp.comparator;

import java.util.Comparator;

public class StringIncreaseComparatorByLengthAndAlphabeticallyOrder implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        return (length1 == length2) ? s1.compareTo(s2) : length1 - length2;
    }
}
