package by.itstep.karnei.phonebook.service;

import by.itstep.karnei.phonebook.exception.PhoneNumberAlreadyExistException;
import by.itstep.karnei.phonebook.exception.ContactAlreadyExistException;
import by.itstep.karnei.phonebook.model.Contact;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface PhoneBookServiceInterface {

    Contact createContact(Contact contact) throws IOException, ClassNotFoundException, PhoneNumberAlreadyExistException, ContactAlreadyExistException;

    void addContactToPhoneBook(Contact contact) throws IOException, ClassNotFoundException, PhoneNumberAlreadyExistException, ContactAlreadyExistException;

    List<String> browseName (String fileName) throws IOException, ClassNotFoundException;
}
