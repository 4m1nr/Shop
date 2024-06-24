import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final static ArrayList<String> roles = (ArrayList<String>) List.of("admin","user");
    private final String id;
    private String name, lastName, phoneNumber, emailAddress;
    private String hashedPassword,role;
    private ArrayList<Address> adrresses;

    public User(String id, String name, String lastName, String phoneNumber, String emailAddress, String hashedPassword, ArrayList<Address> addresses, String role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.hashedPassword = hashedPassword;
        this.adrresses = addresses;
        this.role = role;
    }

    public String getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getEmailAddress() {return emailAddress;}
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}

    public String getRole() {return role;}
    public void setRole(String role) {if (roles.contains(role)) this.role = role;}

    public ArrayList<Address> getAddresses() {return adrresses;}
    public void addAddress(Address address) {
        adrresses.add(address);}
    public void removeAddress(Address address) {
        adrresses.remove(address);}
    public void removeAddress(int index) {
        adrresses.remove(index);}
    public void removeAllAddresses() {
        adrresses.clear();}

    public String getHashedPassword() {return hashedPassword;}


}