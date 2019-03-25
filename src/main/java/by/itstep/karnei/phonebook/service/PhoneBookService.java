package by.itstep.karnei.phonebook.service;

import by.itstep.karnei.phonebook.exception.*;
import by.itstep.karnei.phonebook.model.Contact;
import by.itstep.karnei.phonebook.model.PhoneNumber;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookService implements PhoneBookServiceInterface {

    private static final String FILE_NAME = "phonebook.dat";
    private File file = new File(FILE_NAME);
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public Contact createContact(Contact contact) throws IOException
            , ClassNotFoundException
            , PhoneNumberAlreadyExistException
            , ContactAlreadyExistException
            , NotValidEMailException
            , EMailAlreadyExistException {

        checkEMail(contact);
        if (file.exists() && file.length() != 0) {
            Contact contact1 = cheсkFileContainContaсt(contact);
            if (contact1 != null) {
                return contact1;
            } else {
                return null;
            }
        } else {
            file.createNewFile();
            return contact;
        }
    }

    private void checkEMail(Contact contact) throws NotValidEMailException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(contact.geteMail());
        if (!matcher.matches()) {
            throw new NotValidEMailException();
        }
    }

    private Contact cheсkFileContainContaсt(Contact contact) throws IOException
            , ClassNotFoundException
            , ContactAlreadyExistException
            , PhoneNumberAlreadyExistException
            , EMailAlreadyExistException {

        ArrayList<Contact> list = getContacts();
        for (Contact contact1 : list) {
            if (contact1.equals(contact)) {
                throw new ContactAlreadyExistException();
            } else if (contact1.geteMail().equals(contact.geteMail())) {
                throw new EMailAlreadyExistException();
            } else {
                for (PhoneNumber phoneNumber1 : contact1.getPhoneNumber()) {
                    for (PhoneNumber phoneNumber : contact.getPhoneNumber()) {
                        if (phoneNumber.equals(phoneNumber1)) {
                            throw new PhoneNumberAlreadyExistException();
                        }
                    }
                }
            }
        }
        return contact;
    }

    public void addContactToPhoneBook(Contact contact) throws IOException
            , ClassNotFoundException
            , PhoneNumberAlreadyExistException
            , ContactAlreadyExistException
            , NotValidEMailException
            , EMailAlreadyExistException {

        if (file.exists()) {
            if (file.length() != 0) {
                Contact contaсt1 = cheсkFileContainContaсt(contact);
                recordContact(contaсt1);
            } else {
                createContact(contact);
                recordContact(contact);
            }
        } else {
            createContact(contact);
            recordContact(contact);
        }
    }

    private void recordContact(Contact contact) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(contact);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public List<String> browseName(String fileName) throws IOException, ClassNotFoundException {
        ArrayList<Contact> list = getContacts();
        ArrayList<String> listName = new ArrayList<>();
        list.forEach(e -> listName.add(e.getName()));
        return listName;
    }

    private ArrayList<Contact> getContacts() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ArrayList<Contact> list = new ArrayList<>();
        try {
            for (; ; ) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                list.add((Contact) objectInputStream.readObject());
            }
        } catch (EOFException e) {
        }
        return list;
    }

    public List<Contact> searchContactByName(String name) throws IOException
            , ContactNotFoundException
            , ClassNotFoundException {

        ArrayList<Contact> list = getContacts();
        ArrayList<Contact> newList = new ArrayList<>();
        list.forEach(e -> {
            if (e.getName().equals(name)) newList.add(e);
        });
        if (newList.size() == 0) {
            throw new ContactNotFoundException();
        }
        return newList;
    }

    public List<Contact> searchContactByPhoneNumber(String number) throws IOException
            , ContactNotFoundException
            , ClassNotFoundException {

        ArrayList<Contact> list = getContacts();
        ArrayList<Contact> newList = new ArrayList<>();
        list.forEach(e -> e.getPhoneNumber().forEach(el -> {
            if (el.getNumber().equals(number)) {
                newList.add(e);
            }
        }));
        if (newList.size() == 0) {
            throw new ContactNotFoundException();
        }
        return newList;
    }
}


