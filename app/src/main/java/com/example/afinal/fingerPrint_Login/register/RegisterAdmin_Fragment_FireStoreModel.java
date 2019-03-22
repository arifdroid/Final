package com.example.afinal.fingerPrint_Login.register;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;
import java.util.Observable;

public class RegisterAdmin_Fragment_FireStoreModel extends Observable {

    private String name;
    private String phone;

    private String nameadmincheck=null;

    private boolean returnLast;

  //  private RegisterAdmin_Fragment_Presenter presenter;

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
        returnLast = false;
    }

    public boolean getFromFireStore(){

        //check if admin exist in collection
        final CollectionReference collectionReference =FirebaseFirestore.getInstance().collection("admins_offices");

        Query query_admin = collectionReference.whereEqualTo("admin_phone",phone);

        query_admin.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if(task.isSuccessful()){

                    QuerySnapshot querySnapshot =task.getResult();

                    if(querySnapshot.size()>1){

                        for(QueryDocumentSnapshot documentSnapshot:querySnapshot){

                            Map<String,Object> map;

                            map= documentSnapshot.getData();

                            for(Map.Entry<String,Object> remap: map.entrySet()){

                                if(remap.getKey().equals("name")){

                                    nameadmincheck= remap.getValue().toString();
                                }
                            }

                        }

                    }


                } //try again, connection problem?


            }


        }).addOnCanceledListener(new OnCanceledListener() {
            @Override
            public void onCanceled() {

           // noticeString="failed";



            }
        });

        //this will only run once.
        if(nameadmincheck!=null&&nameadmincheck.equals(name)){

            return true;
        }else {


            return false;

        }
    }

    public boolean getFromFireStore_Simulation(){

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {



                setResponse(true);
            }
        },5000);



        return returnLast;
    }

    private void setResponse(boolean returndata) {

        if(returndata==true) {
            returnLast = returndata;

            setChanged();
            notifyObservers();
        }else {
            return;
        }


    }



    public boolean getReturnLast(){
        return returnLast;
    }




}
