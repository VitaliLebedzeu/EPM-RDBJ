package com.epam.jbmp.counter;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class NumbersSumForkJoinCounter extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 3;

    private final List<Integer> numbers;
    private final int numbersSize;

    public NumbersSumForkJoinCounter(List<Integer> numbers) {
        this.numbers = numbers;
        this.numbersSize = numbers.size();
    }

    @Override
    protected Integer compute() {
        if (numbersSize < THRESHOLD) {
            return sum();
        }
        NumbersSumForkJoinCounter firstTask = new NumbersSumForkJoinCounter(numbers.subList(0, numbersSize / 2));
        firstTask.fork();
        NumbersSumForkJoinCounter secondTask = new NumbersSumForkJoinCounter(numbers.subList(numbersSize / 2, numbersSize));
        Integer secondTaskResult = secondTask.compute();
        Integer firstTaskResult = firstTask.join();
        return firstTaskResult + secondTaskResult;
    }

    private int sum() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
