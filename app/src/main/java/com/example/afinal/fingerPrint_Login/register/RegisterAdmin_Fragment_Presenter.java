package com.example.afinal.fingerPrint_Login.register;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class RegisterAdmin_Fragment_Presenter extends Observable implements Observer {

    // https://www.youtube.com/watch?v=Asc4hU1iSTU&list=PLOzDKCBkR50Set8l8vzp4sWSumCy6Z6Nf&index=35&t=652s

    private  OurView ourView;

    //private String responseFinal;

    private boolean returnFinal;

    private RegisterAdmin_Fragment_FireStoreModel modelFireStore;

    //singleton

    private static RegisterAdmin_Fragment_Presenter INSTANCE;

    public static RegisterAdmin_Fragment_Presenter getINSTANCE(){
        if(INSTANCE==null){


            return INSTANCE = new RegisterAdmin_Fragment_Presenter();

        }return INSTANCE;
    }


    public RegisterAdmin_Fragment_Presenter() {

        //this.responseFinal = null;
        this.returnFinal = false;

       // this.check =false;
       // this.ourView = ourView;

    }

    public boolean checkEmpty(String name, String phone){

        if(!name.isEmpty()&& !phone.isEmpty()){

            return true;
        }

        return false;
    }

    public boolean checkAdminFromFirebase(String name,String phone){


        modelFireStore = RegisterAdmin_Fragment_FireStoreModel.getInstance(name,phone);

        modelFireStore.addObserver(this);

        modelFireStore.getFromFireStore_Simulation();



        //check before changed. always checking.,

        //problem with this design is that, it is always
//        setChanged();
//        notifyObservers();

            //allow to log in



        return returnFinal;
    }

//    public boolean isCheck() {
//        //return check;
//    }

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof RegisterAdmin_Fragment_FireStoreModel){

            //boolean

            boolean check = ((RegisterAdmin_Fragment_FireStoreModel) o).getReturnLast();

            if(check==true) {

                returnFinal = check; //this is should be true now

                setChanged();
                notifyObservers();
            }else {

                return;
            }

        }

    }

    public boolean getReturnFinal(){

        modelFireStore.deleteObserver(this);
        return  returnFinal;
    }


}
