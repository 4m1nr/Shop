public class Address {
    private String street, city, state, zipCode, country;
    private String phoneNumber, FirstName, LastName;
    private String location;

    public Address(String street, String city, String state, String zipCode, String country, String phoneNumber, String FirstName, String LastName, String location) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.location = location;
    }
}
