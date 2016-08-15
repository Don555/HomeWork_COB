package com.framework.checker;

import java.math.BigDecimal;
import java.math.BigInteger;

import static com.framework.util.Helper.INFINITY;
import static com.framework.util.Helper.NAN;
import static com.framework.util.Helper.SCALE;

public class Calculator {
    public static String calculate(String firstNum, String secondNum, Operations value){
        try {

            switch (value) {
                case ADDITION:
                    return new BigInteger(firstNum).add(new BigInteger(secondNum)).toString();
                case SUBTRACTION:
                    return new BigInteger(firstNum).subtract(new BigInteger(secondNum)).toString();
                case MULTIPLICATION:
                    return new BigInteger(firstNum).multiply(new BigInteger(secondNum)).toString();
                case DIVISION:
                    return new BigDecimal(firstNum).divide(new BigDecimal(secondNum), SCALE, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toString();
                case MODULO:
                    return new BigInteger(firstNum).remainder(new BigInteger(secondNum)).toString();
                default:
                    throw new AssertionError("Unknown operations " + value);
            }

        }catch (NumberFormatException e){
            return NAN;
        } catch (ArithmeticException e) {
            if(firstNum.startsWith("-")||secondNum.startsWith("-")){
                return "-"+INFINITY;
            } else {
                return INFINITY;
            }
        }


    }
}
