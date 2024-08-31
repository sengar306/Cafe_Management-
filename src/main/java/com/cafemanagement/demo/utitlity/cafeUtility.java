package com.cafemanagement.demo.utitlity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class cafeUtility
{
    private cafeUtility()
    {

    }
    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus status)
    {
        return new ResponseEntity<String>("{\"message\"\""+responseMessage+"\"  }",status);
    }

}
