package ComplexJson2MapPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressComplexJson2 {
    @JsonProperty("Street")
    private String street;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("pin code")
    private int pinCode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
