package com.epam.jbmp.comparator;

import javafx.util.Pair;

import java.util.Comparator;

public class PairDecreaseComparatorByValueAndAlphabeticallyOrder implements Comparator<Pair<String, Long>> {

    @Override
    public int compare(Pair<String, Long> p1, Pair<String, Long> p2) {
        long pairValue1 = p1.getValue();
        long pairValue2 = p2.getValue();
        return (pairValue1 - pairValue2 == 0) ? p1.getKey().compareTo(p2.getKey()) : (int) (pairValue2 - pairValue1);
    }
}
