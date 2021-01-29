package com.paypal.bfs.test.employeeserv.Service;
import BusinessServices.BusinessResourceNotFoundException;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDAO empDAO;


    public Employee addEmployeeDetails( Employee employeeDetails ) {
        int employeeID = empDAO.getEmployeeList().size()+1;
        employeeDetails.setId(employeeID );
        return empDAO.createEmployee(employeeDetails);
    }

    public Employee getEmployeeDetailsByID( String empID ) throws BusinessResourceNotFoundException {
        Employee emp = empDAO.getEmployeeByID(empID);
        if ( emp != null ) {
            return emp;
        } else {
            throw new BusinessResourceNotFoundException( "Employee [" + empID +"] is not found." );
        }
    }

}