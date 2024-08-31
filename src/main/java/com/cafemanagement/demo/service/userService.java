package com.cafemanagement.demo.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface userService {
    ResponseEntity<String> signup(Map<String, String> requestMap);

}
