package by.itstep.karnei.phonebook.model;

import java.util.Map;
import java.util.Set;

public class Contact {
    private String name;
    private String surname;
    private String nickName;
    private PhoneNumber phoneNumber;
    private int bornYear;
    private String eMail;

    public Contact() {
    }

    public Contact(String name, String surname, String nickName, PhoneNumber phoneNumber, int bornYear, String eMail) {
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

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
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
}
