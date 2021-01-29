package com.paypal.bfs.test.employeeserv.validation;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiValidation {

    List<String> idempotentList = new ArrayList<>( );
    public boolean verifyResource(String key){
        if(idempotentList.contains( key)){
            return true;
        }else{
            idempotentList.add(key);
            return false;
        }

    }

     public String  createEmployeeFieldsValidation( Employee employeeDetails ) {
        String mandatoryFields = null;
        if ( employeeDetails.getAddress( ).getLine1( ) == null || employeeDetails.getAddress( ).getLine1( ).trim( ).isEmpty( ) ) {
            mandatoryFields = "Please Provide address Line1." + "/n";
        }

        if ( employeeDetails.getAddress( ).getCity( ) == null || employeeDetails.getAddress( ).getCity( ).trim( ).isEmpty( ) ) {
            if ( mandatoryFields != null ) {
                mandatoryFields = mandatoryFields + " Please Provide City Name." + "/n";
            } else {
                mandatoryFields = " Please Provide City Name." + "/n";
            }
        }
        if ( employeeDetails.getAddress( ).getCountry( ) == null || employeeDetails.getAddress( ).getCountry( ).trim( ).isEmpty( ) ) {
            if ( mandatoryFields != null ) {
                mandatoryFields = mandatoryFields + " Please Provide Country Name." + "/n";
            } else {
                mandatoryFields = " Please Provide Country Name." + "/n";
            }
        }

        if ( employeeDetails.getAddress( ).getZipCode( ) == null || employeeDetails.getAddress( ).getZipCode( ).trim( ).isEmpty( ) ) {
            if ( mandatoryFields != null ) {
                mandatoryFields = mandatoryFields + " Please Provide zip code." + "/n";
            } else {
                mandatoryFields = " Please Provide zip code." + "/n";
            }
        }

        if ( employeeDetails.getAddress( ).getState( ) == null || employeeDetails.getAddress( ).getState( ).trim( ).isEmpty( ) ) {
            if ( mandatoryFields != null ) {
                mandatoryFields = mandatoryFields + " Please Provide State." + "/n";
            } else {
                mandatoryFields = " Please Provide State." + "/n";
            }
        }

        return mandatoryFields;
    }
}