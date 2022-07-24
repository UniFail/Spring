package com.example.Login.Service;

import com.example.Login.exceptions.WrongLoginException;
import com.example.Login.exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public interface LoginService {
    static boolean validate(String login, String password, String confirmPassword){
        try {
            check(login,password,confirmPassword);
            return true;
        }
        catch (WrongLoginException | WrongPasswordException e){
            return false;
        }
    }
    static void check(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException{
        if (login.length() <= 20 && Pattern.matches("[a-zA-Z0-9+_]+", login));
        else
            throw new WrongLoginException("Wrong login");
        if  (password.length() < 20
                && Pattern.matches("[a-zA-Z0-9+_]+", password)
                && confirmPassword.equals(password));
        else {
            throw new WrongPasswordException("Wrong password");
        }

    }

}
