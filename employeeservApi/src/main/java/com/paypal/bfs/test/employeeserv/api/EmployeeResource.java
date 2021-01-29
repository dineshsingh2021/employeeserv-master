package com.paypal.bfs.test.employeeserv.api;

import BusinessServices.BusinessResourceNotFoundException;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import BusinessServices.InvalidRequestBusinessServiceException;
import org.springframework.web.bind.annotation.RequestMethod;

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
    ResponseEntity<Employee> employeeGetById(@PathVariable String empID) throws BusinessResourceNotFoundException;
   // List< EmployeeDetails > getEmployeesDetails();
   @RequestMapping(method = RequestMethod.POST,value ="/v1/bfs/addEmployee")
   public ResponseEntity<Employee> addEmployeeDetail(@RequestBody Employee employeeDetails,String idempotentKey) throws InvalidRequestBusinessServiceException;

   // EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDetails employeeDetails,@PathVariable String empid) throws BusinessResourceNotFoundException;

 }
