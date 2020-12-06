package com.epam.jbmp.comparator;

import javafx.util.Pair;

import java.util.Comparator;

public class PairDecreaseComparatorByValueAndAlphabeticallyOrder implements Comparator<Pair<String, Long>> {

    @Override
    public int compare(Pair<String, Long> p1, Pair<String, Long> p2) {
        String pairKey1 = p1.getKey();
        String pairKey2 = p2.getKey();
        return (pairKey1.length() == pairKey2.length()) ? pairKey1.compareTo(pairKey2) : (int) (p1.getValue() - p2.getValue());
    }
}
