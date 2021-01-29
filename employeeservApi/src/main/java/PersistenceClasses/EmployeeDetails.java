package PersistenceClasses;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDetails {
    EmployeeDetails( ) {

    }

    public EmployeeDetails(String id, String firstName, String lastName, String birthDate, Address address ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getFirstName( ) {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName( ) {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getBirthDate( ) {
        return birthDate;
    }

    public void setBirthDate( String birthDate ) {
        this.birthDate = birthDate;
    }

    public Address getAddress( ) {
        return address;
    }

    public void setAddress( Address address ) {
        this.address = address;
    }


    String firstName;
    String lastName;
    String birthDate;
    String id;

    public String getId( ) {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    @Autowired
    Address address;
}