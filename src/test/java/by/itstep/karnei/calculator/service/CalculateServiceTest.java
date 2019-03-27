package by.itstep.karnei.calculator.service;

import by.itstep.karnei.calculator.exception.DivisionByZeroException;
import by.itstep.karnei.calculator.exception.IllegalArgumentException;
import by.itstep.karnei.calculator.exception.InvalidNumberOfArgumentsOperationException;
import by.itstep.karnei.calculator.model.Calculator;
import by.itstep.karnei.calculator.model.MathOperation;
import org.junit.Test;


import java.io.IOException;


public class CalculateServiceTest {

    private CalculateInterface calculateInterface = new Calculate();

    @Test
    public void testPositiveCalculate() throws IOException
            , DivisionByZeroException
            , IllegalArgumentException
            , InvalidNumberOfArgumentsOperationException {

        Calculator calculator = new Calculator(60, 20, MathOperation.DIVISION);
        Calculator calculator1 = new Calculator(256, MathOperation.SQUARE_ROOT);
        Calculator calculator2 = new Calculator(256, 26, MathOperation.SUBTRACTION);
        Calculator calculator3 = new Calculator(2, 8, MathOperation.EXPONENTIATION);
        Calculator calculator4 = new Calculator(25, 4, MathOperation.MULTIPLICATION);
        Calculator calculator5 = new Calculator(5, 10, MathOperation.ADD);

        calculateInterface.calculate(calculator);
        calculateInterface.calculate(calculator1);
        calculateInterface.calculate(calculator2);
        calculateInterface.calculate(calculator3);
        calculateInterface.calculate(calculator4);
        calculateInterface.calculate(calculator5);
    }

    @Test(expected = InvalidNumberOfArgumentsOperationException.class)
    public void testNegativeCalculateCalculatorConstructorSquareRoot() throws InvalidNumberOfArgumentsOperationException
            , DivisionByZeroException
            , IllegalArgumentException
            , IOException {
        Calculator calculator2 = new Calculator(256, 3, MathOperation.SQUARE_ROOT);
        calculateInterface.calculate(calculator2);

    }

    @Test(expected = InvalidNumberOfArgumentsOperationException.class)
    public void testNegativeCalculateCalculatorConstructor() throws InvalidNumberOfArgumentsOperationException
            , DivisionByZeroException
            , IllegalArgumentException
            , IOException {
        Calculator calculator2 = new Calculator(256, MathOperation.SUBTRACTION);
        calculateInterface.calculate(calculator2);

    }


    @Test
    public void testNegativeWithDivisionByZeroException() throws IllegalArgumentException
            , IOException
            , InvalidNumberOfArgumentsOperationException {
        Calculator calculator = new Calculator(60, 0, MathOperation.DIVISION);
        try {
            calculateInterface.calculate(calculator);
        } catch (DivisionByZeroException ex) {
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWithInvalidArgumentException() throws IllegalArgumentException
            , IOException
            , InvalidNumberOfArgumentsOperationException
            , DivisionByZeroException {
        Calculator calculator1 = new Calculator(0, MathOperation.SQUARE_ROOT);
        calculateInterface.calculate(calculator1);
    }

}
