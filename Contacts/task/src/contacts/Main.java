package contacts;

import java.io.*;
import java.util.Scanner;

class Menu {
    PhoneBook phoneBook = new PhoneBook();
    public void run() {
        Scanner sc = new Scanner(System.in);

        boolean isRun = true;
        while(isRun) {
            System.out.print("[menu] Enter action (add, remove, edit, count, info, exit):");
            System.out.print("[menu] Enter action (add, list, search, count, exit):");
            String ops = sc.nextLine();
            switch (ops) {
                case "add":
                    phoneBook.add(addcontact());
                    saveBook();
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
                case "info":
                    //listcontact();
                    infocontact();
                    break;
                case "exit":
                    isRun = false;
                    break;
            }
        }
    }

    public Contact addcontact() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the type (person, organization):");
        String type = sc.nextLine();
        Contact c = new Person("", "");

        switch (type) {
            case "person":
                System.out.println("Enter the name of the person:");
                String name = sc.nextLine();
                System.out.println("Enter the surname of the person:");
                String surname = sc.nextLine();
                Person contact = new Person(name, surname);
                System.out.println("Enter the birth date:");
                String birth = sc.nextLine();
                contact.setBirth(birth);
                System.out.println("Enter the gender (M, F):");
                String gender = sc.nextLine();
                contact.setGender(gender);
                System.out.println("Enter the number:");
                String phone = sc.nextLine();
                contact.setPhone(phone);
                System.out.println("The record added.");
                System.out.println();
                return contact;
            case "organization":
                System.out.println("Enter the organization name:");
                String orgname = sc.nextLine();
                System.out.println("Enter the address:");
                String address = sc.nextLine();
                Org org = new Org(orgname, address);
                System.out.println("Enter the number:");
                String phoneorg = sc.nextLine();
                org.setPhone(phoneorg);
                System.out.println("The record added.");
                System.out.println();
                return org;
        }
        return c;
    }

    public void removecontact() {
        Scanner sc = new Scanner(System.in);
        if (phoneBook.getSize() > 0) {
            listcontact();
            System.out.println("Select a record:");
            String record = sc.nextLine();
            phoneBook.remove(Integer.parseInt(record) - 1);
            System.out.println();

        } else {
            System.out.println("No records to remove!");
        }
    }

    public void infocontact() {
        Scanner sc = new Scanner(System.in);
        if (phoneBook.getSize() > 0) {
            listcontact();
            System.out.println("Select a record:");
            String record = sc.nextLine();
            phoneBook.info(Integer.parseInt(record) - 1);
        } else {
            System.out.println("No records!");
        }
    }

    public void editcontact () {
        Scanner sc = new Scanner(System.in);
        if (phoneBook.getSize() > 0) {
            listcontact();
            System.out.println("Select a record:");
            String record = sc.nextLine();
                System.out.println(phoneBook.listActions(Integer.parseInt(record) - 1));
                String opsEdit = sc.nextLine();
                switch (opsEdit) {
                    case "name":
                        System.out.println("Enter name:");
                        String name = sc.nextLine();
                        //phoneBook.setCName(Integer.parseInt(record) - 1, name);
                        phoneBook.setField(Integer.parseInt(record) - 1, opsEdit, name);
                        break;
                    case "surname":
                        System.out.println("Enter surname:");
                        String surname = sc.nextLine();
                        //phoneBook.setCSurname(Integer.parseInt(record) - 1, surname);
                        phoneBook.setField(Integer.parseInt(record) - 1, opsEdit, surname);
                        break;
                    case "number":
                        System.out.println("Enter number:");
                        String number = sc.nextLine();
                        phoneBook.setCPhone(Integer.parseInt(record) - 1, number);
                        break;
                    case "birth":
                        System.out.println("Enter the birth date:");
                        String birth = sc.nextLine();
                        //phoneBook.setCBirth(Integer.parseInt(record) - 1, birth);
                        phoneBook.setField(Integer.parseInt(record) - 1, opsEdit, birth);
                        break;
                    case "gender":
                        System.out.println("Enter the gender(M, F):");
                        String gender = sc.nextLine();
                        //phoneBook.setCGender(Integer.parseInt(record) - 1, gender);
                        phoneBook.setField(Integer.parseInt(record) - 1, opsEdit, gender);
                        break;
                    case "address":
                        System.out.println("Enter address:");
                        String address = sc.nextLine();
                        //phoneBook.setOAddress(Integer.parseInt(record) - 1, address);
                        phoneBook.setField(Integer.parseInt(record) - 1, "address", address);
                        break;
                }
                System.out.println();
            System.out.println();
        } else {
            System.out.println("No records to edit!");
            System.out.println();
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

    public void saveBook() {
        try {
            //Scanner sc = new Scanner(System.in);
            File file = new File("phonebook.db");
            FileOutputStream fs = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            //os.writeObject(this.m);
            os.writeObject(this.phoneBook);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadBook(String input) {
        try {
            File file = new File(input);
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
            this.phoneBook = (PhoneBook) is.readObject();
            is.close();
        } catch (Exception ex) {
            //System.out.println("Cannot load the maze. It has an invalid format");
            ex.printStackTrace();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        if (args.length > 0) {
            menu.loadBook(args[1]);
        }
        menu.run();
    }
}
