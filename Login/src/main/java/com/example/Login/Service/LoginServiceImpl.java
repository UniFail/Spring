package com.example.Login.Service;

import com.example.Login.Domain.LoginInfo;
import com.example.Login.exceptions.WrongLoginException;
import com.example.Login.exceptions.WrongPasswordException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Pattern;

@Service
public class LoginServiceImpl implements LoginService {
    private final LoginInfo[] dataInfo;
    private int size;

    public LoginServiceImpl() {
        this.dataInfo = new LoginInfo[10];
    }
    public boolean check(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        LoginInfo loginInfo = new LoginInfo(login,password,confirmPassword);

        if (login.length() > 3 && Pattern.matches("[a-zA-Z0-9+_]+", login) == false)
            throw new WrongLoginException();
        return false;
        if (password.length() > 3
                && Pattern.matches("[a-zA-Z0-9+_]+", password) == false
                && confirmPassword.equals(password) == false)
            return false;
            throw new WrongPasswordException();
        return true;
    }
}
