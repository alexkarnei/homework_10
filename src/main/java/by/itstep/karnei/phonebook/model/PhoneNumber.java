package by.itstep.karnei.phonebook.model;

import java.io.Serializable;
import java.util.Objects;

public class PhoneNumber implements Serializable {
    private NumberType numberType;
    private String number;

    public PhoneNumber(NumberType numberType, String number) {
        this.numberType = numberType;
        this.number = number;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(NumberType numberType) {
        this.numberType = numberType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "numberType=" + numberType +
                ", number=" + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return getNumber() == that.getNumber() &&
                getNumberType() == that.getNumberType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberType(), getNumber());
    }
}
