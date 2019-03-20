package by.itstep.karnei.phonebook.model;

public class PhoneNumber {
    private NumberType numberType;
    private Integer number;

    public PhoneNumber(NumberType numberType, Integer number) {
        this.numberType = numberType;
        this.number = number;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(NumberType numberType) {
        this.numberType = numberType;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
