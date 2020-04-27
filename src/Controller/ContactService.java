package Controller;

import Model.Contact;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactService extends Contact {
    ArrayList<Contact> contactList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void displayContactList(){
        for (Contact contact : contactList){
            System.out.println(contact.toString());
        }
    }

    public void addContact(String name, String phoneNumber, String group, String dateOfBirth, String gender, String email, String address){
        Contact contact = new Contact(name, phoneNumber, group, dateOfBirth, gender, email, address);
        contactList.add(contact);
    }

    public boolean updateContact(String phoneNumber){
        for (Contact contact : contactList){
            if (contact.getPhoneNumber() == phoneNumber){
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
        int userChoice = scanner.nextInt();
        if (userChoice == 1){
            System.out.println("Enter phone number to search: ");
            String phoneNumber = scanner.nextLine();
            for (Contact contact : contactList){
                if (contact.getPhoneNumber().equals(phoneNumber)){
                    System.out.println(contact.toString());
                    return;
                }
            }
            System.out.println("Phone number not found");
            return;
        } else if (userChoice == 2){
            System.out.println("Enter contact name to search");
            String name = scanner.nextLine();
            for (Contact contact : contactList){
                if (contact.getName().equals(name)){
                    System.out.println(contact.toString());
                    return;
                }
            }
            System.out.println("Name not found");
            return;
        }
    }
}
