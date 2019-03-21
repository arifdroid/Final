package com.example.afinal.fingerPrint_Login.register;

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

public class RegisterAdmin_Fragment_FireStoreModel {

    private String name;
    private String phone;

    private String nameadmincheck=null;

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

//can do after all finish, keeping inline.

//                        if(nameadmincheck!=null){
//                            //means document exist, and name exist, can return and process to
//                            //click button, or next.
//                        }else {
//
//                            //return with error, got number, no admin name, check admin name again
//                        }

                    }


                } //try again, connection problem?


            }
        }).addOnCanceledListener(new OnCanceledListener() {
            @Override
            public void onCanceled() {



            }
        });

        if(nameadmincheck!=null&&nameadmincheck.equals(name)){

            return true;
        }

        return false;
    }


    //
//    public RegisterAdmin_Fragment_FireStoreModel(String name, String phone) {
//
//        this.name=name;
//        this.phone = phone;
//    }


}
