package by.itstep.karnei.calculator.model;

public enum MathOperation {
    ADD("Сложение","+"),
    MULTIPLICATION("Умножение","*"),
    DIVISION("Деление","/"),
    SUBTRACTION("Вычетание","-"),
    SQUARE_ROOT("Извлечение квадратного корня","Math.sqrt"),
    EXPONENTIATION("Возведение в степень" ,"^");

    private String operation;
    private String nameOperation;

    MathOperation() {
    }

    MathOperation(String nameOperation, String operation) {
        this.operation = operation;
        this.nameOperation = nameOperation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getNameOperation() {
        return nameOperation;
    }

    public void setNameOperation(String nameOperation) {
        this.nameOperation = nameOperation;
    }
}
