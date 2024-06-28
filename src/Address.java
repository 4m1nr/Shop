public class Address {
    private String street, city, state, zipCode, country;

    public Address(String street, String city, String state, String zipCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    @Override
    public String toString() {
        String string = "Country: " + country + " \\State: " + state + "\\City: " + city + "\\Street: " + street + "\\ZipCode: " + zipCode;
        return string;
    }
}
