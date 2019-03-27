package by.itstep.karnei.calculator.model;

import by.itstep.karnei.calculator.exception.InvalidNumberOfArgumуntsOperationException;

public class Calculator {
    private int variableNumber;
    private int howMuchIsСhanging;
    private MathOperation mathOperation;

    public Calculator() {
    }
    public Calculator(int variableNumber,  MathOperation mathOperation) throws InvalidNumberOfArgumуntsOperationException {
        if (mathOperation.equals(MathOperation.SQUARE_ROOT)){
        this.variableNumber = variableNumber;
        this.howMuchIsСhanging = 2;
        this.mathOperation = mathOperation;}
        else{
            throw new InvalidNumberOfArgumуntsOperationException();
        }
    }

    public Calculator(int variableNumber, int howMuchIsСhanging, MathOperation mathOperation) throws InvalidNumberOfArgumуntsOperationException {
        if(mathOperation.equals(MathOperation.SQUARE_ROOT)){
            throw new InvalidNumberOfArgumуntsOperationException();
        }
        this.variableNumber = variableNumber;
        this.howMuchIsСhanging = howMuchIsСhanging;
        this.mathOperation = mathOperation;
    }

    public int getVariableNumber() {
        return variableNumber;
    }

    public void setVariableNumber(int firstNumber) {
        this.variableNumber = firstNumber;
    }

    public int getHowMuchIsСhanging() {
        return howMuchIsСhanging;
    }

    public void setHowMuchIsСhanging(int howMuchIsСhanging) {
        this.howMuchIsСhanging = howMuchIsСhanging;
    }

    public MathOperation getMathOperation() {
        return mathOperation;
    }

    public void setMathOperation(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
    }
}
