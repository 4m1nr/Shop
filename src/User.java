import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final static ArrayList<String> roles = (ArrayList<String>) List.of("admin","user");
    private static int nextID = 1;
    private /*should be final ?*/ String id;
    private String name, lastName, phoneNumber, emailAddress;
    private String hashedPassword,role;
    private ArrayList<Address> adrresses;
    private Cart cart = new Cart();

    public User(String name, String lastName, String phoneNumber, String emailAddress, String hashedPassword, ArrayList<Address> addresses,Cart cart, String role) {
        generateId();
        setName(name);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
        this.hashedPassword = hashedPassword;
        this.adrresses = addresses;
        setRole(role);
    }

    //initialize getters and setters
    //getters
    public String getId() {return id;}
    public String getName() {return name;}
    public String getLastName() {return lastName;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getEmailAddress() {return emailAddress;}
    public String getRole() {return role;}
    public ArrayList<Address> getAddresses() {return adrresses;}
    public Cart getCart() {return cart;}
    public String getHashedPassword() {return hashedPassword;}

    //setters
    private void generateId() {
        this.id = String.valueOf(nextID++);}

    public void setName(String name) {
        this.name = name;}

    public void setLastName(String lastName) {
        this.lastName = lastName;}

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;}

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;}

    public void setRole(String role) {if (roles.contains(role)) this.role = role;}

    public void addAddress(Address address) {
        adrresses.add(address);}
    public void removeAddress(Address address) {
        adrresses.remove(address);}
    public void removeAddress(int index) {
        adrresses.remove(index);}
    public void removeAllAddresses() {
        adrresses.clear();}

    public void setCart(Cart cart) {
        this.cart = cart;}
}