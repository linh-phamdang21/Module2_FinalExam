package FileIO;

import Model.Contact;

import java.io.*;
import java.util.ArrayList;

public class ContactIO {
    private static final String DEFAULT_FILE_PATH = "data/contact.csv";

    public void readFile(){
        File file = new File(DEFAULT_FILE_PATH);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            try {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                ArrayList resultList = (ArrayList) objectInputStream.readObject();
                for (Object contact : resultList){
                    System.out.println(contact);
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                try {
                    if (objectInputStream != null){
                        objectInputStream.close();
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeFile(ArrayList<Contact> contactList){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            File file;
            fileOutputStream = new FileOutputStream(DEFAULT_FILE_PATH);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(contactList);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null){
                    objectOutputStream.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
