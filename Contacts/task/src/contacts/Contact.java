package contacts;

public class Contact {
    private String name = "";
    private String surname = "";
    private String phone = "[no number]";

    public Contact(String name, String surname){
        this.name = name;
        this.surname = surname;
        System.out.println("A record created!");
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        if (checkPhone(phone)) {
            this.phone = phone;
        } else {this.phone = "[no number]";}
    }

    public boolean isPhone () {
        return !phone.equals("");
    }

    public String toString() {
        return (this.name + " " + this.surname + ", " + this.phone);
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

}

class Person extends Contact {

    public Person(String name, String surname) {
        super(name, surname);
    }
}
