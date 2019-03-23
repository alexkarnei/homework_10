package by.itstep.karnei.phonebook.service;

import by.itstep.karnei.phonebook.exception.PhoneNumberAlreadyExistException;
import by.itstep.karnei.phonebook.exception.ContactAlreadyExistException;
import by.itstep.karnei.phonebook.model.Contact;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookService implements PhoneBookServiceInterface {

    private static final String FILE_NAME = "phonebook.txt";
    private File file = new File(FILE_NAME);

    public Contact createContact(Contact contact) throws IOException, ClassNotFoundException, PhoneNumberAlreadyExistException, ContactAlreadyExistException {
        if (!file.exists()) {
            file.createNewFile();
            return contact;
        } else if (file.length() != 0) {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
           Contact contact1 = (Contact) objectInputStream.readObject();
            if (contact1.getPhoneNumber().equals(contact.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExistException();
            }
            objectInputStream.close();
            return contact;
        }
        return contact;
    }

    public void addContactToPhoneBook(Contact contact) throws IOException, ClassNotFoundException, PhoneNumberAlreadyExistException, ContactAlreadyExistException {
        if (file.exists()) {
            if (file.length() != 0) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Contact contact1 = createContact((Contact) objectInputStream.readObject());
                recordContact(contact);
                objectInputStream.close();
            }
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
        List<String> listName = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Contact contact = (Contact) objectInputStream.readObject();
        listName.add(contact.getName());
        return listName;
    }
}

