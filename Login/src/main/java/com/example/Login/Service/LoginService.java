package com.example.Login.Service;

import com.example.Login.exceptions.WrongLoginException;
import com.example.Login.exceptions.WrongPasswordException;

public interface LoginService {
    boolean check(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException;
}
