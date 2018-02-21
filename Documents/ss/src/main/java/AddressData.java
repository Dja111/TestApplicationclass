public class AddressData {
    public String street, city;
    public int houseNumber, postalCode;

    public AddressData(String street, int houseNumber, int postalCode, String city) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
    }
}
