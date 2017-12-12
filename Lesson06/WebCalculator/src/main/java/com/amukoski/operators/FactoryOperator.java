package com.amukoski.operators;

import com.amukoski.operators.exception.OperatorNotAllowedException;
import com.amukoski.operators.impl.AddOperator;
import com.amukoski.operators.impl.SubtractOperator;

public class FactoryOperator {

    public static Operator provideOperator(String operationName) {
        if (operationName.equalsIgnoreCase("Add")) {
            return new AddOperator();
        } else if (operationName.equalsIgnoreCase("Subtract")) {
            return new SubtractOperator();
        }

        throw new OperatorNotAllowedException(operationName + " not allowed");
    }
}
