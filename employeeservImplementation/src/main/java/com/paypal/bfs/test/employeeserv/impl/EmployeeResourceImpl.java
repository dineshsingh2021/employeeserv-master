package com.paypal.bfs.test.employeeserv.impl;
import BusinessServices.BusinessResourceNotFoundException;


import BusinessServices.InvalidRequestBusinessServiceException;
import com.paypal.bfs.test.employeeserv.Service.EmployeeService;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.validation.ApiValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    /*
    @ApiParam id - provide empid to get employee detils.
    */
    @ApiOperation(value = "Get employee details by passing employee id.")
     public ResponseEntity<Employee> employeeGetById(@PathVariable String id) throws BusinessResourceNotFoundException {
        return new ResponseEntity<>(service.getEmployeeDetailsByID(id), HttpStatus.OK);
    }

    /*
    @ApiParam line2 in address field is optional
    @ApiParam line1 is mandatory field
    @ApliParam city is mandatory field
    @ApiParam zipcode is madatory field
    @ApiParam country is mandatroy filed
    @ApiParam employee fname is mandatory field
    @ApiParam employee lname is mandatory field
     */
    @ApiOperation(value = "This service allow user to create employee. Except line 2 all fields are madatory.")
    public ResponseEntity<Employee> addEmployeeDetail(@RequestBody Employee employeeDetails,@RequestHeader(value = "idempotent-key") String idempotentKey) throws InvalidRequestBusinessServiceException {
        String mandatoryFields = apiValidation.createEmployeeFieldsValidation( employeeDetails );
        if ( mandatoryFields != null ) {
            throw new InvalidRequestBusinessServiceException( mandatoryFields );
        }
        // verify if this resource is already created and user is trying to create same resource again.
        boolean idempotent =apiValidation.verifyResource(idempotentKey);

        if(!idempotent) {
            return new ResponseEntity<>(service.addEmployeeDetails(employeeDetails), HttpStatus.CREATED);
        }else{
            throw new InvalidRequestBusinessServiceException( "This resource is already created." );
        }
    }
}
