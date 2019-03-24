package com.example.afinal.fingerPrint_Login.register.register_user_activity;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

class RegUser_Presenter extends Observable implements RegUser_Presenter_Interface, Observer {


    private RegUser_Model_Interface model_interface;

    private RegUserView_Interface view_interface;

    private boolean gotDoc;


    public RegUser_Presenter(RegUserView_Interface view_interface) {

        this.view_interface = view_interface;
        model_interface = new RegUser_Model();

        ((RegUser_Model) model_interface).addObserver(this);
    }


    @Override
    public void checkUserDoc(String name, String phone, String adminName, String adminPhone) {

        boolean doublecheck = checkInputValid(name,phone);

        if(doublecheck){

            boolean triplecheck = checkInputValid(adminName,adminPhone);

            if(triplecheck){

                //we need to tell this now, now it is set at false.

                gotDoc = model_interface.checkUserDoc_Model(name,phone,adminName,adminPhone);

                if(gotDoc){


                    view_interface.checkDocResult("doc created");

                }else {

                    view_interface.checkDocResult("false :cannot create doc");

                }



            }
        }

    }

    @Override
    public boolean checkInputValid(String name, String phone) {

        if((name!=null&& phone!=null)||(name!="" && phone!="")){

            Log.i("checkk UserReg: ", "99");
            return true;
        }

        Log.i("checkk UserReg: ", "00");
        return false;
    }

    @Override
    public boolean checkInputValid(String name, String phone, String code) {
        if((name!=null&& phone!=null&& code!=null)||(name!="" && phone!=""&& code!="")){

            Log.i("checkk UserReg: ", "code 1");
            return true;
        }

        Log.i("checkk UserReg: ", " code 2");
        return false;
    }

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof  RegUser_Model){

            //((RegUser_Model) o).returnCheckDoc_Updated();

            boolean updatedCheckDoc = ((RegUser_Model) o).getReturnDoc_Updated();

            if(updatedCheckDoc==true){

                gotDoc = updatedCheckDoc;

                setChanged();
                notifyObservers();


                setStatus("doc created");

            }else {
                return;
            }

        }
    }

    private void setStatus(String doc_created) {

        view_interface.checkDocResult(doc_created);

    }
}
