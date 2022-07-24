package com.example.Login.Controller;

import com.example.Login.Service.LoginService;
import com.example.Login.exceptions.WrongLoginException;
import com.example.Login.exceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(path = "/form")
    public boolean getPassportInfo(@RequestParam("login") String login,
                                  @RequestParam("password") String password,
                                  @RequestParam("confirmPassword") String confirmPassword) {

       boolean result = LoginService.validate(login,password,confirmPassword);
       if(result) {
          return true;
       }
       else {
           return false;
       }
    }
}
