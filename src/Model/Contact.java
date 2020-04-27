package Model;

public class Contact {
    private String name;
    private String phoneNumber;
    private String group;
    private String dateOfBirth;
    private String gender;
    private String email;
    private String address;

    public Contact(){

    }

    public Contact(String name, String phoneNumber, String group, String dateOfBirth, String gender, String email, String address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.group = group;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%-25s" + "%-30s" + "%-25s" + "%-25s" + "%-30s" + "%-30s" + "%-35s",
                this.name, this.phoneNumber, this.group, this.dateOfBirth, this.gender, this.email, this.address );
    }
}
