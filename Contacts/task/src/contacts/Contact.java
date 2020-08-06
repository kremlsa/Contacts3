package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Contact implements Serializable {
    private String phone = "[no number]";
    private LocalDateTime created;
    private LocalDateTime edited;
    private boolean isPerson = false;

    public Contact () {
        created = LocalDateTime.now().withSecond(0);
    }

    public boolean isPerson() {
        return isPerson;
    }

    public void setIsPerson() {
        this.isPerson = true;
    }

    public void setPhone(String phone) {
        if (checkPhone(phone)) {
            this.phone = phone;
        } else {this.phone = "[no number]";}
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void setEdited() {
        this.edited = LocalDateTime.now().withSecond(0);
    }

    public boolean isPhone () {
        return !phone.equals("");
    }
    public String getPhone() {
        return phone;
    }

    public boolean checkPhone (String phone) {
        if (phone.matches("[+]*[0-9]+ (?=.[0-9\\(\\)]).{2,} ([0-9A-Za-z].*).{2,}")
                || phone.matches("[+]*[0-9\\(\\)].+ (?=.[0-9]+).{2,} ([0-9A-Za-z].+)*.{2,}")
                || phone.matches("[+]*[0-9]+")
                || phone.matches("[+]*[0-9]+ [0-9a-zA-Z]*")
                || phone.matches("[0-9a-zA-z-]+")
                || phone.matches("\\(*[*0-9a-zA-z]+\\)")
                || phone.matches("\\+\\(*[*0-9a-zA-z]+\\)")
                || phone.matches("\\(*[*0-9a-zA-z].+\\) [0-9a-zA-z].+")
                || phone.matches("\\(*[0-9a-zA-z].+\\)-[0-9a-zA-z]+.[0-9a-zA-Z]+")
                || phone.matches("[0-9a-zA-z-]+ [0-9a-zA-z-]+")
                || phone.matches("[0-9].+-\\(*[*0-9a-zA-z]+\\)")) {
            return true;
        } else {
            System.out.println("Wrong number format!");
            return false;}
    }

    public void getInfo() {
        System.out.println("Number: " + phone + "\n" +
                "Time created: " + created + "\n" +
                "Time last edit: " + edited);
    }

    public abstract String getField(String name);

    public abstract void setField(String name, String value);

    public abstract String getActions();


}

class Person extends Contact {
    private String name = "";
    private String surname = "";
    //private String phone = "[no number]";
    private String gender = "[no data]";
    private String birth = "[no data]";

    public String getActions() {
        return "Select a field (name, surname, birth, gender, number):";
    }

    public Person(String name, String surname){
        super();
        this.name = name;
        this.surname = surname;
        super.setIsPerson();
        //System.out.println("A record created!");
    }

    public String getField(String name) {
        switch (name) {
            case "name":
                return getName();
            case "surname":
                return getSurname();
            case "gender":
                return getGender();
            case "birth":
                return getBirth();

        }
        return "";
    }

    public void setField(String name, String value) {
        switch (name) {
            case "name":
                setName(value);
                break;
            case "surname":
                setSurname(value);
                break;
            case "gender":
                setGender(value);
                break;
            case "birth":
                setBirth(value);
                break;

        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String toString() {
        return (this.name + " " + this.surname + ", " + super.getPhone());
    }

    public void setPhone(String phone) {
     super.setPhone(phone);
    }

    public void setBirth(String birth) {
        if (!birth.equals("")) {
            this.birth = birth;
        } else {
            System.out.println("Bad birth date!");
            this.birth = "[no data]";
        }
    }

    public void setGender(String gender) {
        if (gender.equals("M") || gender.equals("F")) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
    }

    public String getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public void getInfo() {
        System.out.println("Name: " + this.name + "\n" +
                        "Surname: " + this.surname + "\n" +
                        "Birth date: " + this.birth + "\n" +
                        "Gender: " + this.gender + "\n" +
                        "Number: " + super.getPhone() + "\n" +
                        "Time created: " + super.getCreated() + "\n" +
                        "Time last edit: " + super.getEdited());
        System.out.println();
    }

}

class Org extends Contact {
    private String orgname = "";
    private String address = "";
    private String phone = "[no number]";

    public String getActions() {
        return "Select a field (name, address, number):";
    }

    public Org(String orgname, String address){
        super();
        this.orgname = orgname;
        this.address = address;
        //System.out.println("The record created!");
    }

    public String getField(String name) {
        switch (name) {
            case "name":
                return getOrgName();
            case "surname":
                return getAddress();
        }
        return "";
    }

    public void setField(String name, String value) {
        switch (name) {
            case "name":
                setOrgName(value);
                break;
            case "address":
                setAddress(value);
                break;
        }
    }

    public String getOrgName() {
        return orgname;
    }

    public String getAddress() {
        return address;
    }

    public void setOrgName(String orgname) {
        this.orgname = orgname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return (this.orgname + " " + this.address + ", " + this.phone);
    }

    public void getInfo() {
        System.out.println("Organization name: " + this.orgname + "\n" +
                "Address: " + this.address + "\n" +
                "Number: " + super.getPhone() + "\n" +
                "Time created: " + super.getCreated() + "\n" +
                "Time last edit: " + super.getEdited());
        System.out.println();
    }

}