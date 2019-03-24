package com.example.afinal.fingerPrint_Login.test_mvp;

public interface IUser {

    String getName();
    String getPassword();

    int checkUserValidity(String name, String pass);
}
