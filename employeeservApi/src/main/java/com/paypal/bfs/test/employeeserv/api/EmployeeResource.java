package com.paypal.bfs.test.employeeserv.api;

import BusinessServices.BusinessResourceNotFoundException;
import PersistenceClasses.EmployeeDetails;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import BusinessServices.InvalidRequestBusinessServiceException;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);
    List< EmployeeDetails > getEmployeesDetails();
    public void addEmployeeDetail(@RequestBody EmployeeDetails employeeDetails,String idempotentKey) throws InvalidRequestBusinessServiceException;
    EmployeeDetails getEmployeeDetails(@PathVariable String empID) throws BusinessResourceNotFoundException;
    EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDetails employeeDetails,@PathVariable String empid) throws BusinessResourceNotFoundException;

    // ----------------------------------------------------------
    // TODO - add a new operation for creating employee resource.
    // ----------------------------------------------------------
}
