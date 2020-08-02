package contacts;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    List<Contact> contacts;

    PhoneBook() {
        contacts = new ArrayList<Contact>();
    }

    public void add(Contact contact) {
        contacts.add(contact);
        System.out.println("The record added.");
    }

    public void remove(int num) {
        contacts.remove(num);
        System.out.println("The record removed.");
    }

    public int getSize() {
        return contacts.size();
    }

    public List<Contact> getContacts () {
        return this.contacts;
    }

    public void setCName(int num, String name) {
        contacts.get(num).setName(name);
        System.out.println("The record updated!");
    }

    public void setCSurname(int num, String surname) {
        contacts.get(num).setSurname(surname);
        System.out.println("The record updated!");
    }

    public void setCPhone(int num, String phone) {
        contacts.get(num).setPhone(phone);
        System.out.println("The record updated!");
    }

}
