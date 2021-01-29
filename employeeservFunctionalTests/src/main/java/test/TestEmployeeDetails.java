/*
package test;

import BusinessServices.BusinessResourceNotFoundException;
import BusinessServices.InvalidRequestBusinessServiceException;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDAO;
import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;
import com.paypal.bfs.test.employeeserv.Service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestEmployeeDetails {
    @InjectMocks
    EmployeeResourceImpl empImpl;
    @InjectMocks
    EmployeeDAO empDAO;

    @Mock
    EmployeeService dao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void createEmployeeTest() throws InvalidRequestBusinessServiceException
    {
    Employee emp = empDAO.getEmployeeByID( valueOf( 1 ) );
    emp.setId(1000);

        empDAO.createEmployee(emp);
        verify(dao, times(1)).addEmployeeDetails(emp);
    }

    @Test
    public void getEmployeeByIdTest() throws BusinessResourceNotFoundException {
        when(empDAO.getEmployeeByID(valueOf(1))).thenReturn(empDAO.getEmployeeList().get(0)
                );
        ResponseEntity<Employee> emp = empImpl.employeeGetById(valueOf(1));
        assertEquals("Dinesh", emp.getBody().getFirstName());
        assertEquals("Singh", emp.getBody().getLastName());
        assertEquals("Pune", emp.getBody().getAddress().getCity());
        assertEquals(valueOf( 1 ), emp.getBody().getId());
    }
}
*/
