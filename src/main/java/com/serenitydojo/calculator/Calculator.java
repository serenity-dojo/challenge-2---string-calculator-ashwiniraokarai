package com.serenitydojo.calculator;

import org.apache.commons.lang3.StringUtils;

public class Calculator {
    public int evaluate(String expression) throws IllegalMathsOperatorException {
        String result = "0";

        if(expression.isEmpty()){
            return 0;
        }

        String[] arrayOfStrings = expression.split("\\s");

        result = arrayOfStrings[0];

        for(int i = 0; i < arrayOfStrings.length - 1; i=i+2){
            result = operate(result, arrayOfStrings[i+1], arrayOfStrings[i+2]);
        }

        return Integer.parseInt(result);
    }

    public String operate (String one, String operator, String two) throws IllegalMathsOperatorException{
        int integerOne = Integer.parseInt(one);
        int integerTwo = Integer.parseInt(two);

        Integer integerResult;

        switch(operator){
            case "+": integerResult = integerOne + integerTwo; break;
            case "-": integerResult = integerOne - integerTwo; break;
            case "*": integerResult = integerOne * integerTwo; break;
            default: integerResult = -1; //-1 is code for "don't recognize this operator. I will mark this to throw an exception eventually"
        }

        if(integerResult == -1){
            throw new IllegalMathsOperatorException("Cannot recognize operator: " + operator );
        }
        return integerResult.toString();
    }
}
