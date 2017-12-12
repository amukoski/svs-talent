package com.amukoski.operators.impl;

import com.amukoski.operators.Operator;

import java.util.Arrays;

public class AddOperator implements Operator {
    @Override
    public Integer apply(Integer... numbers) {
        return Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
    }
}
