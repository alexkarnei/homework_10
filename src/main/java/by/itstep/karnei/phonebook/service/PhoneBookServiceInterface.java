package by.itstep.karnei.phonebook.service;

import by.itstep.karnei.phonebook.exception.*;
import by.itstep.karnei.phonebook.model.Contact;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface PhoneBookServiceInterface {

    Contact createContact(Contact contact) throws IOException
            , ClassNotFoundException
            , PhoneNumberAlreadyExistException
            , ContactAlreadyExistException
            , NotValidEMailException
            , EMailAlreadyExistException;

    void addContactToPhoneBook(Contact contact) throws IOException
            , ClassNotFoundException
            , PhoneNumberAlreadyExistException
            , ContactAlreadyExistException
            , NotValidEMailException
            , EMailAlreadyExistException;

    List<String> browseName(String fileName) throws IOException
            , ClassNotFoundException;

    List<Contact> searchContactByName(String name) throws IOException
            , ContactNotFoundException
            , ClassNotFoundException;

    List<Contact> searchContactByPhoneNumber(String number) throws IOException
            , ContactNotFoundException
            , ClassNotFoundException;
}
