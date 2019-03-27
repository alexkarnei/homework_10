package by.itstep.karnei.calculator.service;

import by.itstep.karnei.calculator.exception.DivisionByZeroException;
import by.itstep.karnei.calculator.exception.IllegalArgumentException;
import by.itstep.karnei.calculator.model.Calculator;
import by.itstep.karnei.calculator.model.MathOperation;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculate implements CalculateInterface {

    private static final String FILE_NAME = "calculate.txt";
    private File file = new File(FILE_NAME);

    public void calculate(Calculator calculator) throws IOException, DivisionByZeroException, IllegalArgumentException {
        if (!file.exists()) {
            file.createNewFile();
            writeCalculateOperation(calculator);
        } else {
            writeCalculateOperation(calculator);
        }
    }

    private void writeCalculateOperation(Calculator calculator) throws IOException, DivisionByZeroException, IllegalArgumentException {
        FileWriter writer = new FileWriter(FILE_NAME, true);
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append("Операция : ")
                .append(calculator.getMathOperation().getNameOperation())
                .append(", ")
                .append(new SimpleDateFormat("dd.MM.yyyy в HH:mm:ss").format(new Date()))
                .append(" : ")
                .append(calculator.getVariableNumber())
                .append(calculator.getMathOperation().getOperation())
                .append(calculator.getHowMuchIsСhanging())
                .append(" = ")
                .append(callCalculateOperation(calculator));
        writer.write(sb.toString()+"\r\n");
        writer.flush();
        writer.close();
    }

    private BigDecimal callCalculateOperation(Calculator calculator) throws DivisionByZeroException
            , IllegalArgumentException {
        MathOperation i = calculator.getMathOperation();
        switch (i) {
            case ADD:
                return add(calculator);
            case MULTIPLICATION:
                return multiplication(calculator);
            case DIVISION:
                return division(calculator);
            case SUBTRACTION:
                return subtraction(calculator);
            case EXPONENTIATION:
                return exponentiation(calculator);
            case SQUARE_ROOT:
                return mathSqrt(calculator);
            default:
                return null;

        }
    }

    private BigDecimal add(Calculator calculator) {
        int x = calculator.getVariableNumber();
        int y = calculator.getHowMuchIsСhanging();
        int result = x + y;
        return BigDecimal.valueOf(result);
    }

    private BigDecimal multiplication(Calculator calculator) {
        int x = calculator.getVariableNumber();
        int y = calculator.getHowMuchIsСhanging();
        int result = x * y;
        return BigDecimal.valueOf(result);
    }

    private BigDecimal subtraction(Calculator calculator) {
        int x = calculator.getVariableNumber();
        int y = calculator.getHowMuchIsСhanging();
        int result = x - y;
        return BigDecimal.valueOf(result);
    }

    private BigDecimal division(Calculator calculator) throws DivisionByZeroException {
        int x = calculator.getVariableNumber();
        int y = calculator.getHowMuchIsСhanging();
        if (y == 0) {
            throw new DivisionByZeroException();
        } else {
            int result = x / y;
            return BigDecimal.valueOf(result);
        }
    }

    private BigDecimal exponentiation(Calculator calculator) {
        int x = calculator.getVariableNumber();
        int y = calculator.getHowMuchIsСhanging();
        int result = (int) Math.pow(x, y);
        return BigDecimal.valueOf(result);
    }

    private BigDecimal mathSqrt(Calculator calculator) throws IllegalArgumentException {
        int x = calculator.getVariableNumber();
        if (x <= 0 ) {
            throw new IllegalArgumentException();
        }
        int result = (int) Math.sqrt(x);
        return BigDecimal.valueOf(result);
    }
}
