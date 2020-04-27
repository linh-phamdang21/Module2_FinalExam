package Controller;

import Model.Contact;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactService extends Contact {
    ArrayList<Contact> contactList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void displayContactList(){
        System.out.printf("%-25s" + "%-30s" + "%-25s" + "%-25s" + "%-30s" + "%-30s" + "%-35s","Name","Phone number", "Group", "Date of Birth", "Gender", "Email", "Address");
        System.out.println();
        for (Contact contact : contactList){
            System.out.println(contact.toString());
        }
        System.out.println();
    }

    public void addContact(String name, String phoneNumber, String group, String dateOfBirth, String gender, String email, String address){
        Contact contact = new Contact(name, phoneNumber, group, dateOfBirth, gender, email, address);
        contactList.add(contact);
    }

    public boolean updateContact(String phoneNumber){
        for (Contact contact : contactList){
            if (contact.getPhoneNumber().equals(phoneNumber)){
                System.out.println("Please add information to edit contact: ");
                System.out.println("New group: ");
                String newGroup = scanner.nextLine();
                contact.setGroup(newGroup);
                System.out.println("New name: ");
                String newName = scanner.nextLine();
                contact.setName(newName);
                System.out.println("New gender: ");
                String newGender = scanner.nextLine();
                contact.setGender(newGender);
                System.out.println("New address: ");
                String newAddress = scanner.nextLine();
                contact.setAddress(newAddress);
                System.out.println("New date of birth: ");
                String newDateOfBirth = scanner.nextLine();
                contact.setDateOfBirth(newDateOfBirth);
                System.out.println("New email: ");
                String newEmail = scanner.nextLine();
                contact.setEmail(newEmail);
                return true;
            }
        }
        System.out.println("Phone number not found");
        return false;
    }

    public boolean deleteContact(String phoneNumber){
        for (int i = 0; i < contactList.size(); i++){
            if (contactList.get(i).getPhoneNumber().equals(phoneNumber)){
                contactList.remove(i);
                System.out.println("Contact deleted");
                return true;
            }
        }
        System.out.println("Phone number not found");
        return false;
    }

    public void searchContact(){
        System.out.println("Search by: ");
        System.out.println("1. Phone number");
        System.out.println("2. Name");
        int userChoice = inputUserChoice();
        switch (userChoice){
            case 1:
                System.out.println("Enter phone number to search: ");
                String phoneNumber = scanner.nextLine();
                for (Contact contact : contactList){
                    if (contact.getPhoneNumber().equals(phoneNumber)){
                        System.out.println(contact.toString());
                        break;
                    }
                }
                System.out.println("Phone number not found");
                break;
            case 2:
                String name = inputName();
                for (Contact contact : contactList){
                    if (contact.getName().equals(name)){
                        System.out.println(contact.toString());
                        break;
                    }
                }
                System.out.println("Name not found");
                break;
        }
    }

    public int inputUserChoice(){
        int userChoice = scanner.nextInt();
        return userChoice;
    }

    public String inputName(){
        System.out.println("Enter contact's name: ");
        String name = scanner.nextLine();
        return name;
    }

    public String inputPhoneNumber(){
        System.out.println("Enter contact's phone number: ");
        String phoneNumber = scanner.nextLine();
        return phoneNumber;
    }

    public String inputGroup(){
        System.out.println("Enter contact's group: ");
        String group = scanner.nextLine();
        return group;
    }

    public String inputDateOfBirth(){
        System.out.println("Enter contact's date of birth: ");
        String dateOfBirth = scanner.nextLine();
        return dateOfBirth;
    }

    public String inputGender(){
        System.out.println("Enter contact's gender: ");
        String gender = scanner.nextLine();
        return gender;
    }

    public String inputEmail(){
        System.out.println("Enter contact's email: ");
        String email = scanner.nextLine();
        return email;
    }

    public String inputAddress(){
        System.out.println("Enter contact's address: ");
        String address = scanner.nextLine();
        return address;
    }
}
