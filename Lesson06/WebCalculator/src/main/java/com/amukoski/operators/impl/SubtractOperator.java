package com.amukoski.operators.impl;

import com.amukoski.operators.Operator;

import java.util.Arrays;

public class SubtractOperator implements Operator {
    @Override
    public Integer apply(Integer... numbers) {
        return Arrays.stream(numbers).reduce((a, b) -> a - b).get();
    }
}
