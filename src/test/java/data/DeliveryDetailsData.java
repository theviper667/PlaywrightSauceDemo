package data;

public class DeliveryDetailsData {
    private String firstname;
    private String lastname;
    private String zipcode;

    public DeliveryDetailsData (String firstname, String lastname, String zipcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.zipcode = zipcode;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getZipCode() {
        return zipcode;
    }

}
