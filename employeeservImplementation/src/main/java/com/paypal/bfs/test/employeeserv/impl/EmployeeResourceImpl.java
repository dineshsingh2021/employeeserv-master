package com.paypal.bfs.test.employeeserv.impl;
import PersistenceClasses.EmployeeDetails;
import BusinessServices.BusinessResourceNotFoundException;


import BusinessServices.InvalidRequestBusinessServiceException;
import com.paypal.bfs.test.employeeserv.Service.EmployeeService;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.validation.ApiValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Implementation class for employee resource.
 */
@RestController
@Api(value = "Employee Details." , description = "Operations on employess info.")
public class EmployeeResourceImpl implements EmployeeResource {
    @Autowired
    EmployeeService service;

    @Autowired
    ApiValidation apiValidation;

    @ApiOperation(value = "Get employee details by passing employess id.")
    @RequestMapping(value = "/employees/{empID}")
    public EmployeeDetails getEmployeeDetails(@PathVariable String empID) throws BusinessResourceNotFoundException {
        return  service.getEmployeeDetailsByID(empID);
    }

    @ApiOperation(value = "Create Employee Resources.")
    @RequestMapping(method = RequestMethod.POST,value ="/addEmployeeDetails")
    public void addEmployeeDetail(@RequestBody EmployeeDetails employeeDetails,@RequestHeader(value = "idempotent-key") String idempotentKey) throws InvalidRequestBusinessServiceException {
        System.out.println( "**************idempotent-key******************" +idempotentKey );
        boolean idempotent =apiValidation.verifyResource(idempotentKey);
        if(!idempotent) {
            String mandatoryFields = apiValidation.createEmployeeFieldsValidation( employeeDetails );
            if ( mandatoryFields != null ) {
                throw new InvalidRequestBusinessServiceException( mandatoryFields );
            }
            service.addEmployeeDetails( employeeDetails );
        }else{
            throw new InvalidRequestBusinessServiceException( "This resource is already created." );
        }
    }

    /*Please ignore given below api's as I have written for my refernce.
    Eventhough in mail I have provided documation of below apis. */

    @ApiOperation(value = "This update api is not part of requirement but I have written for my reference only. You may ignore this.Update emplyee details by passing employess id.")
    @RequestMapping(method = RequestMethod.PUT,value ="/updateEmployeeDetails/{empid}")
    public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDetails employeeDetails,@PathVariable String empid) throws BusinessResourceNotFoundException{
        EmployeeDetails employee = service.getEmployeeDetailsByID(empid);
        return service.updateEmployeeDetails( employeeDetails, empid);

    }

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {

        Employee employee = new Employee();
        employee.setId(Integer.valueOf(id));
        employee.setFirstName("BFS");
        employee.setLastName("Developer");

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees")
    @ApiOperation(value = "This getEmployeesDetails api is not part of requirement but I have written for my reference only. This will return all employees.")
    public List<EmployeeDetails> getEmployeesDetails() {
        return  service.getAllEmplyee();
    }

}
