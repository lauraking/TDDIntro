package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i == 0) return 1;
        else {
            return i * compute(i - 1);
        }

    }

    public Integer computeIterative(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int factorial = 1;
        for (int j = 1; j <= i; j++) {
            factorial = factorial * j;
        }
        return factorial;
    }


}
