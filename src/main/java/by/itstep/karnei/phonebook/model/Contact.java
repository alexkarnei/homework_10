package by.itstep.karnei.phonebook.model;

import java.io.Serializable;
import java.util.*;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String nickName;
    private List<PhoneNumber> phoneNumber;
    private int bornYear;
    private String eMail;

    public Contact() {
    }

    public Contact(String name
            , String surname
            , String nickName
            , List<PhoneNumber> phoneNumber
            , int bornYear
            , String eMail) {

        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.bornYear = bornYear;
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<PhoneNumber> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<PhoneNumber> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact1 = (Contact) o;
        return getBornYear() == contact1.getBornYear() &&
                getName().equals(contact1.getName()) &&
                getSurname().equals(contact1.getSurname()) &&
                getNickName().equals(contact1.getNickName()) &&
                getPhoneNumber().equals(contact1.getPhoneNumber()) &&
                geteMail().equals(contact1.geteMail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getNickName(), getPhoneNumber(), getBornYear(), geteMail());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", bornYear=" + bornYear +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
