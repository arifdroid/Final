package com.example.afinal.fingerPrint_Login.register.register_with_activity;

public interface RegAdminPresenter_Interface {

    boolean checkInputValid(String name, String phone);
    boolean checkFromFirebaseSimulation(String name,String phone);
    boolean checkFinalFromFirebase();




    void resultPresenter(String s);


}
