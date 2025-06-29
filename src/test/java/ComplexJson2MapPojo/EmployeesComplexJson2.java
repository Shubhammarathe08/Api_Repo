package ComplexJson2MapPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeesComplexJson2 {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private double salary;
    @JsonProperty("Address")
    private AddressComplexJson2 address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public AddressComplexJson2 getAddress() {
        return address;
    }

    public void setAddress(AddressComplexJson2 address) {
        this.address = address;
    }
}
