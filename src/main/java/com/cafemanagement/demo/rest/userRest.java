package com.cafemanagement.demo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(path="/user")
public interface userRest {

  @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody(required = true)Map<String, String> requestMap);

}
