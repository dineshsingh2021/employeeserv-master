package com.paypal.bfs.test.employeeserv.Service;
import PersistenceClasses.EmployeeDetails;
import PersistenceClasses.Address;
import BusinessServices.BusinessResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private List< EmployeeDetails > emplyoeeDetailList = new ArrayList( Arrays.asList(
            new EmployeeDetails( "1", "Dinesh", "Singh", "05-12-1986", new Address( "B201", "Mukai", "Pune", "MH", "India", "412101" ) ),
            new EmployeeDetails( "2", "Andy", "Junior", "04-02-1985", new Address( "C-401", "Street 5", "St. Louis", "Missouri", "USA", "612101" ) ),
            new EmployeeDetails( "3", "Darshan", "Singh", "06-06-1988", new Address( "D-401", "Street 6", "Chicago", "Missouri", "USA", "712101" ) ) )
    );


    public List< EmployeeDetails > getAllEmplyee( ) {
        return emplyoeeDetailList;
    }

    public void addEmployeeDetails( EmployeeDetails employeeDetails ) {
        int employeeID = emplyoeeDetailList.size()+1;
        employeeDetails.setId(String.valueOf(employeeID) );
        emplyoeeDetailList.add( employeeDetails );
    }

    public EmployeeDetails getEmployeeDetailsByID( String empID ) throws BusinessResourceNotFoundException {

        EmployeeDetails empDetails = emplyoeeDetailList.stream( )
                .filter( emp -> emp.getId( ).equals( empID ) )
                .findAny( )
                .orElse( null );

        if ( empDetails != null ) {
            return empDetails;
        } else {
            throw new BusinessResourceNotFoundException( "Employee [" + empID +"] is not found." );
        }
    }


    public EmployeeDetails updateEmployeeDetails(EmployeeDetails employeeDetails,String empid ){
        int i = 0;
        for(EmployeeDetails list : emplyoeeDetailList){

            if( list.getId().equals(empid) ){
                emplyoeeDetailList.set( i, employeeDetails);
            }
            i++;
        }
     return emplyoeeDetailList.get(i-1);
    }

}