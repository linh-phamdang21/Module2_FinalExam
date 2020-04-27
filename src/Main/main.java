package Main;

import Controller.ContactController;

public class main {
    public static void main(String[] args) {
        ContactController contactController = new ContactController();
        while (true){
            contactController.chooseOption();
        }
    }
}
