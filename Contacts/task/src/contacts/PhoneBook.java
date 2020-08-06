package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook implements Serializable {
    List<Contact> contacts;

    PhoneBook() {
        contacts = new ArrayList<Contact>();
    }

    public void add(Contact contact) {
        contacts.add(contact);
//        System.out.println("The record added.");
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

    public void setField(int num, String name, String value) {
        Contact c = contacts.get(num);
        c.setField(name, value);
        c.setEdited();
        System.out.println("The record updated!");
    }

    public String listActions(int num) {
        return contacts.get(num).getActions();
    }

    public void setCPhone(int num, String phone) {
        contacts.get(num).setPhone(phone);
        contacts.get(num).setEdited();
        System.out.println("The record updated!");
    }

    public void info(int num) {
        contacts.get(num).getInfo();
    }

    public boolean isPerson (int num) {
        return contacts.get(num).isPerson();
    }

}
