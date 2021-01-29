package com.paypal.bfs.test.employeeserv.dao;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.valueOf;

@Service
public class EmployeeDAO {
    EmployeeDAO(){
        Address address1= createAddressObject("B 201","Mukai","Pune","MH","412101","India");
        Address address2= createAddressObject("B 301","Pine road","St. Louis","Missouri","46578","USA");
        createEmpObject(1,"Dinesh","Singh","05-12-1982",address1);
        createEmpObject(2,"Darshan","Singh","05-12-1982",address2);
    }

    private List< Employee > emplyoeeDetailList = new ArrayList( Arrays.asList(

    ) );

    public List<Employee> createEmpObject(Integer id,String fName,String lName,String dob,Address address){
        Employee emp = new Employee();
        emp.setId(id);
        emp.setFirstName(fName);
        emp.setLastName(lName);
        emp.setDateOfBirth(dob);
        emp.setAddress(address);
        emplyoeeDetailList.add(emp);
        return emplyoeeDetailList;
    }

    public Address createAddressObject(String line1,String line2,String city,String state,String zipCode,String country){
        Address address = new Address();
        address.setLine1( line1 );
        address.setLine2( line2 );
        address.setCity( city );
        address.setState(state);
        address.setZipCode(zipCode);
        address.setCountry(country);
        return address;
    }

    public List< Employee >  getEmployeeList(){
        return emplyoeeDetailList;
    }

    public Employee createEmployee(Employee emp){
          emplyoeeDetailList.add(emp);
          return emp;
    }

    public Employee getEmployeeByID(String empID){
        return emplyoeeDetailList.stream( )
                .filter( emp -> emp.getId( ) == (valueOf(empID) ) )
                .findAny( )
                .orElse( null );
    }

}
