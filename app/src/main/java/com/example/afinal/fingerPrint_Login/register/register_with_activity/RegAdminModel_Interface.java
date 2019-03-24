package com.example.afinal.fingerPrint_Login.register.register_with_activity;

public interface RegAdminModel_Interface {

    boolean getFromSimulation(String name, String phone);

    boolean returnSimulation();

    boolean getFromFirebase(String name, String phone);
}
