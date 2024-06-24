import java.util.ArrayList;

public class User {
    private final String id;
    private String name, lastName, phoneNumber, emailAddress;
    private String hashedPassword;
    private ArrayList<Adrress> Addresses;

    public User(String id, String name, String lastName, String phoneNumber, String emailAddress, String hashedPassword) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.hashedPassword = hashedPassword;
        Addresses = new ArrayList<>();
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

    public ArrayList<Adrress> getAddresses() {return Addresses;}
    public void addAddress(Adrress address) {Addresses.add(address);}
    public void removeAddress(Adrress address) {Addresses.remove(address);}
    public void removeAddress(int index) {Addresses.remove(index);}
    public void removeAllAddresses() {Addresses.clear();}

    public String getHashedPassword() {return hashedPassword;}


}