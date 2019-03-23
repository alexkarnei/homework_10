package by.itstep.karnei.phonebook.service;

import by.itstep.karnei.phonebook.exception.PhoneNumberAlreadyExistException;
import by.itstep.karnei.phonebook.exception.ContactAlreadyExistException;
import by.itstep.karnei.phonebook.model.Contact;
import by.itstep.karnei.phonebook.model.NumberType;
import by.itstep.karnei.phonebook.model.PhoneNumber;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookServiceTest {

    private PhoneBookServiceInterface phoneBookService = new PhoneBookService();

    @Test
    public void createContactPositiveTest() throws PhoneNumberAlreadyExistException, IOException, ClassNotFoundException, ContactAlreadyExistException {


        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, 8158575));

        Contact contact = new Contact("Александр"
                , "Карней"
                , "Reyt"
                , phoneNumberList
                , 1985
                , "alex.karnei@gmail.com");

        phoneBookService.createContact(contact);

    }


    @Test(expected = PhoneNumberAlreadyExistException.class)
    public void addContactToPhoneBookNegativeTest() throws PhoneNumberAlreadyExistException, IOException, ClassNotFoundException, ContactAlreadyExistException {

        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, 7841248));
        phoneNumberList.add(new PhoneNumber(NumberType.HOME_PHONE_NUMBER, 660076));

        Contact contact = new Contact("Александр"
                , "Карней"
                , "Reyt"
                , phoneNumberList
                , 1985
                , "alex.karnei@gmail.com");

        phoneBookService.addContactToPhoneBook(phoneBookService.createContact(contact));

        Contact contact1 = new Contact("Александр"
                , "Карней"
                , "Reyt"
                , phoneNumberList
                , 1985
                , "alex.karnei@gmail.com");

        phoneBookService.addContactToPhoneBook(phoneBookService.createContact(contact1));
    }

    @Test
    public void addContactToPhoneBookPositiveTest() throws PhoneNumberAlreadyExistException, IOException, ClassNotFoundException, ContactAlreadyExistException {

        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, 2662361));
        phoneNumberList.add(new PhoneNumber(NumberType.HOME_PHONE_NUMBER, 610093));

        List<PhoneNumber> phoneNumberList1 = new ArrayList<>();
        phoneNumberList1.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, 7184023));
        phoneNumberList1.add(new PhoneNumber(NumberType.HOME_PHONE_NUMBER, 723147));

        Contact contact = new Contact("Иван"
                , "Карней"
                , "Ivan"
                , phoneNumberList
                , 1960
                , "ivan.karnei@gmail.com");

        Contact contact1 = new Contact("Анастасия"
                , "Шутова"
                , "Shutikova"
                , phoneNumberList1
                , 1986
                , "nastya_129@rambler.ru");

        phoneBookService.addContactToPhoneBook(phoneBookService.createContact(contact));
        phoneBookService.addContactToPhoneBook(phoneBookService.createContact(contact1));
    }

    @Test
    public void browsePositiveTest() throws IOException, ClassNotFoundException {

        List <String> name = phoneBookService.browseName("phonebook.txt");
        System.out.println(name);

    }
}
