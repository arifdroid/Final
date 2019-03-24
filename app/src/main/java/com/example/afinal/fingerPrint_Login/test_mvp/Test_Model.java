package com.example.afinal.fingerPrint_Login.test_mvp;

public class Test_Model implements IUser{

    //this is the model class, we passback data to?

    private String name;
    private String password;


    public Test_Model( String name, String password){

        this.name = name;
        this.password=password;

    }

    @Override
    public String getName() {
        //return null;

        return name;
    }

    @Override
    public String getPassword() {
        //return null;
        return password;

    }

    @Override
    public int checkUserValidity(String name, String pass) {
        //return 0;

        if(name==null||pass==null||!name.equals(getName())||!pass.equals(getPassword())){
            return -1;
        }
        return 0;

    }
}
