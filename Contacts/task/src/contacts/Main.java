package contacts;

import java.util.Scanner;

class Menu {
    PhoneBook phoneBook = new PhoneBook();
    public void run() {
        Scanner sc = new Scanner(System.in);

        boolean isRun = true;
        while(isRun) {
            System.out.print("Enter action (add, remove, edit, count, list, exit):");
            String ops = sc.nextLine();
            switch (ops) {
                case "add":
                    phoneBook.add(addcontact());
                    break;
                case "remove":
                    removecontact();
                    break;
                case "edit":
                    editcontact();
                    break;
                case "count":
                    countcontact();
                    break;
                case "list":
                    listcontact();
                    break;
                case "exit":
                    isRun = false;
                    break;
            }
        }
    }

    public Contact addcontact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the person:");
        String name = sc.nextLine();
        System.out.println("Enter the surname of the person:");
        String surname = sc.nextLine();
        System.out.println("Enter the number:");
        String phone = sc.nextLine();
        Contact contact = new Contact(name, surname);
        contact.setPhone(phone);
        return contact;
    }

    public void removecontact() {
        Scanner sc = new Scanner(System.in);
        if (phoneBook.getSize() > 0) {
            listcontact();
            System.out.println("Select a record:");
            String record = sc.nextLine();
            phoneBook.remove(Integer.parseInt(record) - 1);

        } else {
            System.out.println("No records to remove!");
        }
    }

    public void editcontact () {
        Scanner sc = new Scanner(System.in);
        if (phoneBook.getSize() > 0) {
            listcontact();
            System.out.println("Select a record:");
            String record = sc.nextLine();
            System.out.println("Select a field (name, surname, number):");
            String opsEdit = sc.nextLine();
                switch (opsEdit) {
                    case "name":
                        System.out.println("Enter name:");
                        String name = sc.nextLine();
                        phoneBook.setCName(Integer.parseInt(record) - 1, name);
                        break;
                    case "surname":
                        System.out.println("Enter surname:");
                        String surname = sc.nextLine();
                        phoneBook.setCSurname(Integer.parseInt(record) - 1, surname);
                        break;
                    case "number":
                        System.out.println("Enter number:");
                        String number = sc.nextLine();
                        phoneBook.setCPhone(Integer.parseInt(record) - 1, number);
                        break;
                }
        } else {
            System.out.println("No records to edit!");
        }
    }


    public void countcontact () {

        System.out.println("The Phone Book has " + phoneBook.getSize() + " records.");
    }

    public void listcontact() {
        int i = 1;
        for (Contact c : phoneBook.getContacts()) {
            System.out.println(i + ". " + c.toString());
            i++;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
