/*
package test;

import BusinessServices.BusinessResourceNotFoundException;
import BusinessServices.InvalidRequestBusinessServiceException;
import PersistenceClasses.Address;
import PersistenceClasses.EmployeeDetails;

import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;
import com.paypal.bfs.test.employeeserv.Service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestEmployeeDetails {
    @InjectMocks
    EmployeeResourceImpl empImpl;

    @Mock
    EmployeeService dao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllEmployeesTest()
    {
        List< EmployeeDetails > emplyoeeDetailList = new ArrayList( Arrays.asList(
                new EmployeeDetails( "1", "Dinesh", "Singh", "05-12-1986", new Address( "B201", "Mukai", "Pune", "MH", "India", "412101" ) ),
                new EmployeeDetails( "2", "Andy", "Junior", "04-02-1985", new Address( "C-401", "Street 5", "St. Louis", "Missouri", "USA", "612101" ) ),
                new EmployeeDetails( "3", "Darshan", "Singh", "06-06-1988", new Address( "D-401", "Street 6", "Chicago", "Missouri", "USA", "712101" ) ) )
        );

        when(dao.getAllEmplyee()).thenReturn(emplyoeeDetailList);

        //test
        List<EmployeeDetails> empList = empImpl.getEmployeesDetails();

        assertEquals(3, empList.size());
        verify(dao, times(1)).getAllEmplyee();
    }


    @Test
    public void createEmployeeTest() throws InvalidRequestBusinessServiceException
    {
       EmployeeDetails emp = new EmployeeDetails( "100", "David", "Paterson", "05-12-1986", new Address( "B201", "Mukai", "Pune", "MH", "London", "52346" ) );
        empImpl.addEmployeeDetail(emp);

        verify(dao, times(1)).addEmployeeDetails(emp);
    }

    @Test
    public void getEmployeeByIdTest() throws BusinessResourceNotFoundException {
        when(dao.getEmployeeDetailsByID("1")).thenReturn(new EmployeeDetails( "1", "Dinesh", "Singh", "05-12-1986", new Address( "B201", "Mukai", "Pune", "MH", "India", "412101" ) )
                );

        EmployeeDetails emp = empImpl.getEmployeeDetails("1");

        assertEquals("Dinesh", emp.getFirstName());
        assertEquals("Singh", emp.getLastName());
        assertEquals("Pune", emp.getAddress().getCity());
    }
}
*/
