package ComplexJson2MapPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ComplexJson2Pojo {
    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("Street")
    private String street;

    @JsonProperty("City")
    private String city;

    @JsonProperty("State")
    private String state;

    @JsonProperty("pin code")
    private int pinCode;

    @JsonProperty("BankAccounts")
    private List<String> bankAccounts;

    @JsonProperty("employees")
    private List<EmployeesComplexJson2> employees;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

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


    public List<String> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<String> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public List<EmployeesComplexJson2> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeesComplexJson2> employees) {
        this.employees = employees;
    }
}
