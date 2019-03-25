package by.itstep.karnei.calculator.service;

import by.itstep.karnei.calculator.exception.DivisionByZeroException;
import by.itstep.karnei.calculator.exception.IllegalArgumentException;
import by.itstep.karnei.calculator.model.Calculator;

import java.io.IOException;

public interface CalculateInterface {

    void calculate (Calculator calculator) throws IOException, DivisionByZeroException, IllegalArgumentException;
}
