package com.cafemanagement.demo.restimpl;

import com.cafemanagement.demo.constsnts.cafeConstants;
import com.cafemanagement.demo.rest.userRest;
import com.cafemanagement.demo.service.userService;
import com.cafemanagement.demo.utitlity.cafeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class userRestImpl  implements userRest {
    @Autowired
    userService userService;
    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        try{
            return userService.signup(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cafeUtility.getResponseEntity(cafeConstants.something_went_wrong,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
