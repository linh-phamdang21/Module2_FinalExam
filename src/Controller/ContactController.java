package Controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import FileIO.ContactIO;

public class ContactController extends ContactService{
    public static final String PHONE_NUMBER_REGEX ="0[0-9]{9}";
    public static final String EMAIL_REGEX = "^[0-9a-zA-Z][0-9a-zA-Z]*@[0-9a-zA-Z]+(\\.[A-Za-z0-9]+)$";
    Scanner scanner = new Scanner(System.in);
    boolean numberCheck = false;
    boolean emailCheck = false;
    ContactIO contactIO = new ContactIO();

    public boolean validatePhoneNumber(String number){
        Pattern p = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher m = p.matcher(number);
        return m.matches();
    }

    public boolean validateEmail(String email){
        Pattern p = Pattern.compile(EMAIL_REGEX);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public void displayOption(){
        System.out.println("----- CONTACT MANAGEMENT PROGRAM-----");
        System.out.println("1. Display contact list");
        System.out.println("2. Add new contact");
        System.out.println("3. Update contact");
        System.out.println("4. Delete contact");
        System.out.println("5. Search contact");
        System.out.println("6. Read from file");
        System.out.println("7. Write to file");
        System.out.println("8. Exit");
    }

    public void chooseOption(){
        displayOption();
        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:
                displayContactList();
                break;
            case 2:
                System.out.println("Please enter new contact's information: ");
                String name = inputName();
                String phoneNumber = inputPhoneNumber();
                String group = inputGroup();
                String dateOfBirth = inputDateOfBirth();
                String gender = inputGender();
                String email = inputEmail();
                String address = inputAddress();
                addContact(name, phoneNumber, group, dateOfBirth, gender, email, address);
                break;
            case 3:
                String updatePhoneNumber = inputPhoneNumber();
                updateContact(updatePhoneNumber);
                break;
            case 4:
                String delPhoneNumber = inputPhoneNumber();
                deleteContact(delPhoneNumber);
                break;
            case 5:
                searchContact();
                break;
            case 6:
                contactIO.readFile();
                break;
            case 7:
                contactIO.writeFile(contactList);
                break;
            case 8:
                System.exit(0);
        }
    }
}
