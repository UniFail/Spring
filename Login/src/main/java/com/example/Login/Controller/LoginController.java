package com.example.Login.Controller;

import com.example.Login.Service.LoginService;
import com.example.Login.exceptions.WrongLoginException;
import com.example.Login.exceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        final boolean check;
        try {
            check = loginService.check(login,password,confirmPassword);
        } catch (WrongLoginException e) {
            return false;
        } catch (WrongPasswordException e) {
            return false;
        }
        return check;
    }
}
