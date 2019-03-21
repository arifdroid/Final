package com.example.afinal.fingerPrint_Login.register;

public class RegisterAdmin_Fragment_FireStoreModel {

    private String name;
    private String phone;
    private RegisterAdmin_Fragment_Presenter presenter;

    private static RegisterAdmin_Fragment_FireStoreModel INSTANCE;

    public static RegisterAdmin_Fragment_FireStoreModel getInstance(String name, String phone){
        if(INSTANCE==null){
            return new RegisterAdmin_Fragment_FireStoreModel(name,phone);
        }

        return INSTANCE;
    }



    public RegisterAdmin_Fragment_FireStoreModel(String name, String phone){
        this.name=name;
        this.phone=phone;
    }

    public boolean getFromFireStore(){




        return false;
    }


    //
//    public RegisterAdmin_Fragment_FireStoreModel(String name, String phone) {
//
//        this.name=name;
//        this.phone = phone;
//    }


}
