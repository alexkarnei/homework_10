package by.itstep.karnei.phonebook.service;

import by.itstep.karnei.phonebook.exception.*;
import by.itstep.karnei.phonebook.model.Contact;
import by.itstep.karnei.phonebook.model.NumberType;
import by.itstep.karnei.phonebook.model.PhoneNumber;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhoneBookServiceTest {

    private PhoneBookServiceInterface phoneBookService = new PhoneBookService();

    @Test
    public void testPositiveCreateContact() throws IOException
            , ClassNotFoundException
            , ContactAlreadyExistException {

        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, "781248"));

        Contact contact = new Contact("Александр"
                , "Карней"
                , "Reyt"
                , phoneNumberList
                , 1985
                , "alex.karnei@gmail.com");

        try {
            phoneBookService.createContact(contact);
        } catch (PhoneNumberAlreadyExistException | NotValidEMailException | EMailAlreadyExistException e) {
        }
    }

    @Test(expected = NotValidEMailException.class)
    public void testNegativeCreateContact() throws IOException
            , ClassNotFoundException
            , ContactAlreadyExistException
            , NotValidEMailException {

        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, "781248"));
        phoneNumberList.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, "7884373"));
        phoneNumberList.add(new PhoneNumber(NumberType.WORKING_PHONE_NUMBER, "688212"));
        phoneNumberList.add(new PhoneNumber(NumberType.WORKING_PHONE_NUMBER, "688213"));
        Contact contact = new Contact("Александр"
                , "Карней"
                , "Reyt"
                , phoneNumberList
                , 1985
                , "alex()karnei@gmail.com");

        try {
            phoneBookService.createContact(contact);
        } catch (PhoneNumberAlreadyExistException | EMailAlreadyExistException e) {
        }
    }


    @Test(expected = EMailAlreadyExistException.class)
    public void testNegativeAddContactToPhoneBook() throws PhoneNumberAlreadyExistException
            , IOException
            , ClassNotFoundException
            , ContactAlreadyExistException
            , NotValidEMailException
            , EMailAlreadyExistException {

        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, "7841248"));
        phoneNumberList.add(new PhoneNumber(NumberType.HOME_PHONE_NUMBER, "660076"));
        phoneNumberList.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, "7884373"));
        phoneNumberList.add(new PhoneNumber(NumberType.WORKING_PHONE_NUMBER, "688212"));
        phoneNumberList.add(new PhoneNumber(NumberType.WORKING_PHONE_NUMBER, "688213"));

        Contact contact2 = phoneBookService.createContact(new Contact("Александр"
                , "Карней"
                , "Reyt"
                , phoneNumberList
                , 1985
                , "alex.karnei@gmail.com"));

        Contact contact3 = phoneBookService.createContact(new Contact("Александр"
                , "Карней"
                , "Reyt"
                , phoneNumberList
                , 1985
                , "alex.karnei@gmail.com"));

        phoneBookService.addContactToPhoneBook(contact2);
        phoneBookService.addContactToPhoneBook(contact3);
    }

    @Test
    public void testPositiveAddContactToPhoneBook() throws PhoneNumberAlreadyExistException
            , IOException
            , ClassNotFoundException {

        List<PhoneNumber> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, "2662361"));
        phoneNumberList.add(new PhoneNumber(NumberType.HOME_PHONE_NUMBER, "610093"));
        phoneNumberList.add(new PhoneNumber(NumberType.FAX_PHONE_NUMBER, "610094"));

        List<PhoneNumber> phoneNumberList1 = new ArrayList<>();
        phoneNumberList1.add(new PhoneNumber(NumberType.MOBILE_PHONE_NUMBER, "7184023"));
        phoneNumberList1.add(new PhoneNumber(NumberType.HOME_PHONE_NUMBER, "723147"));
        phoneNumberList1.add(new PhoneNumber(NumberType.WORKING_PHONE_NUMBER, "935484"));

        try {
            Contact contact = phoneBookService.createContact(new Contact("Иван"
                    , "Карней"
                    , "Ivan"
                    , phoneNumberList
                    , 1960
                    , "ivan.karnei@gmail.com"));

            Contact contact1 = phoneBookService.createContact(new Contact("Анастасия"
                    , "Шутова"
                    , "Shutikova"
                    , phoneNumberList1
                    , 1986
                    , "nastya_129@rambler.ru"));

            try {
                phoneBookService.addContactToPhoneBook(contact);
                phoneBookService.addContactToPhoneBook(contact1);
            } catch (ContactAlreadyExistException e) {
            }
        } catch (ContactAlreadyExistException | NotValidEMailException | EMailAlreadyExistException ex) {
        }
    }

    @Test
    public void testPositiveBrowse() throws IOException
            , ClassNotFoundException {

        List<String> name = phoneBookService.browseName("phonebook.txt");
        Assert.assertEquals(3, name.size());
        System.out.println(name);

    }

    @Test
    public void testPositiveSearchContactByName() throws IOException
            , ContactNotFoundException
            , ClassNotFoundException {
        List<Contact> list = phoneBookService.searchContactByName("Александр");
        Assert.assertNotEquals(3, list.size());
        Assert.assertEquals(1, list.size());
        System.out.println(list);
    }

    @Test(expected = ContactNotFoundException.class)
    public void testNegativeSearchContactByName() throws IOException
            , ContactNotFoundException
            , ClassNotFoundException {
        phoneBookService.searchContactByName("Андрей");
    }

    @Test
    public void testPositiveSearchContactByPhoneNumber() throws ContactNotFoundException
            , IOException
            , ClassNotFoundException {
        List<Contact> list = phoneBookService.searchContactByPhoneNumber("2662361");
        Assert.assertEquals(1, list.size());
        System.out.println(list);
    }

    @Test(expected = ContactNotFoundException.class)
    public void testNegativeSearchContactByPhoneNumber() throws ContactNotFoundException
            , IOException
            , ClassNotFoundException {
        phoneBookService.searchContactByPhoneNumber("7821942");

    }
}
