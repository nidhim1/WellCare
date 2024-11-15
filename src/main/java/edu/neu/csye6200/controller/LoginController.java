package edu.neu.csye6200.controller;

import edu.neu.csye6200.model.LoginDTO;
import edu.neu.csye6200.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @PostMapping("/checkPost")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        loginService.checkUser(loginDTO);
        String result = null;
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        result = username+":"+password;
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
