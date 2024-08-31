package com.cafemanagement.demo.serviceimpl;

import com.cafemanagement.demo.constsnts.cafeConstants;
import com.cafemanagement.demo.dao.userDao;
import com.cafemanagement.demo.pojo.User;
import com.cafemanagement.demo.service.userService;
import com.cafemanagement.demo.utitlity.cafeUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class userServiceImpl implements userService {
    @Autowired
    userDao userDao;
    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {

     try{

         if(validateSignupMap(requestMap))
         {
             User user = userDao.findByEmail(requestMap.get("email"));
             if(Objects.isNull(user))
             {
                 userDao.save(getuserFromRequestMap(requestMap));
                 return cafeUtility.getResponseEntity("user successfully register",HttpStatus.OK);
             }
             else{
                 return cafeUtility.getResponseEntity("email already register", HttpStatus.BAD_REQUEST);
             }
         }
         else{
             return cafeUtility.getResponseEntity(cafeConstants.validateData, HttpStatus.BAD_REQUEST);
         }

     }
     catch(Exception e)
     {
         e.printStackTrace();
     }

     return cafeUtility.getResponseEntity(cafeConstants.something_went_wrong, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validateSignupMap(Map<String,String> requestMap){
if(requestMap.containsKey("name")&& requestMap.containsKey("contactNumber") && requestMap.containsKey("email")&& requestMap.containsKey("password")
)  {
    return true;
}

   return false;  }
    private  User getuserFromRequestMap(Map<String,String> requestMap){

        User user = new User();
        user.setContactNumber(Objects.requireNonNull(requestMap.get("contactNumber")));
        user.setName(requestMap.get("name"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setRole(requestMap.get("role"));
        user.setStatus(requestMap.get("status"));
        return user;
    }


}
