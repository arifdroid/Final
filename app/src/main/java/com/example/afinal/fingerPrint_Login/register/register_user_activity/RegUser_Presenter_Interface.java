package com.example.afinal.fingerPrint_Login.register.register_user_activity;

import com.google.firebase.auth.PhoneAuthProvider;

interface RegUser_Presenter_Interface {

    void checkUserDoc(String name, String phone, String adminName, String adminPhone);

    boolean checkInputValid(String name, String phone);

    boolean checkInputValid(String name, String phone,String code);
}
