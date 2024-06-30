import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class User {
    private final static ArrayList<String> roles = new ArrayList<>(List.of("ADMIN","USER"));
    private final String id;
    private String name, lastName, phoneNumber, emailAddress;
    private String hashedPassword,role;
    private double balance;
    private ArrayList<Address> adrresses;
    private Cart cart = new Cart();

    public User(String id, String name, String lastName, String phoneNumber, String emailAddress,
                String password, double balance, ArrayList<Address> addresses,Cart cart, String role){
        this.id = id;
        setName(name);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
        this.hashedPassword = password;
        setBalance(balance);
        this.adrresses = addresses;
        setRole(role);
    }

    //initialize getters and setters
    //getters
    public String getId()                               {return id;}
    public String getName()                             {return name;}
    public String getLastName()                         {return lastName;}
    public String getPhoneNumber()                      {return phoneNumber;}
    public String getEmailAddress()                     {return emailAddress;}
    public String getRole()                             {return role;}
    public ArrayList<Address> getAddresses()            {return adrresses;}
    public Cart getCart()                               {return cart;}
    public String getHashedPassword()                   {return hashedPassword;}
    public double getBalance()                          {return balance;}

    //setters
    public void setName(String name)                    {this.name = name;}
    public void setLastName(String lastName)            {this.lastName = lastName;}
    public void setPhoneNumber(String phoneNumber)      {this.phoneNumber = phoneNumber;}
    public void setEmailAddress(String emailAddress)    {this.emailAddress = emailAddress;}
    public void setRole(String role)                    {if (roles.contains(role)) this.role = role;}
    public void addAddress(Address address)             {adrresses.add(address);}
    public void removeAddress(Address address)          {adrresses.remove(address);}
    public void removeAddress(int index)                {adrresses.remove(index);}
    public void removeAllAddresses()                    {adrresses.clear();}
    public void setCart(Cart cart)                      {this.cart = cart;}
    public void setHashedPassword(String hashedPassword){this.hashedPassword = hashedPassword;}
    public void setBalance(double balance)              {this.balance = balance;}

    public boolean checkPassword(String password)       {return this.hashedPassword.equals(HashPassword(password));}

    public static String HashPassword(String password){
        String hashedPassword;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        hashedPassword = Base64.getEncoder().encodeToString(messageDigest.digest(password.getBytes()));
        return hashedPassword;
    }
}