package com.example.afinal.fingerPrint_Login.register;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afinal.R;
import com.example.afinal.fingerPrint_Login.Presenter_FingerPrint;

import java.util.Observable;
import java.util.Observer;

public class RegisterAdmin_Fragment extends Fragment implements OurView, Observer {

    private EditText editTextAdminName, editTextAdminPhone;
    private Button button2;
    private TextView textView;

    private String adminNameHere;
    private String adminPhoneHere;

    private RegisterAdmin_Fragment_Presenter presenter;

    private boolean success;
    private boolean notnull;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.register_admin_fragment,container,false);


        editTextAdminName = rootView.findViewById(R.id.registerAdmin_editText_adminNameID);
        editTextAdminPhone = rootView.findViewById(R.id.registerAdmin_editText_adminPhoneID);
        button2 = rootView.findViewById(R.id.registerAdmin_button_AdminFragment_ID);
        textView = rootView.findViewById(R.id.registerAdmin_textView_AdminFragment_ID);

        success=false;
        notnull=false;

        presenter =  RegisterAdmin_Fragment_Presenter.getINSTANCE();
        presenter.addObserver(this);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String adminName = editTextAdminName.getText().toString();
                String adminPhone = editTextAdminPhone.getText().toString();

                checkAdminExist(adminName,adminPhone);


            }
        });


        return rootView;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        presenter.deleteObserver(this);
    }

    private boolean checkInputExist(String adminName, String adminPhone) {

        boolean check = presenter.checkEmpty(adminName,adminPhone);

        if(check){
            return true;
        }else {
            return false;
        }
    }

    //should we return boolean
    private void checkAdminExist(String adminName, String adminPhone) {

       notnull = checkInputExist(adminName,adminPhone);

        if(notnull){

            //need another observer as well,

            adminNameHere = adminName;
            adminPhoneHere =adminPhone;

            success = presenter.checkAdminFromFirebase(adminName,adminPhone);

            if(success==true){

                goNext();


            }else {

                //if instance all work in flow.
                //this will run first, until we fetch data,
                //how to decide that there will never be an update in data.
                Toast.makeText(getContext(),"admin fail", Toast.LENGTH_SHORT).show();
            }


        }else {

            Toast.makeText(getContext(),"pelase enter detail", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void update(Observable o, Object arg) {

        //need to force check method adminExist.

        if(o instanceof RegisterAdmin_Fragment_Presenter){

            Boolean check = ((RegisterAdmin_Fragment_Presenter)o).getReturnFinal();

            if(check==true){

                textView.setText("success simulation");

                goNext();
            }
        }

    }

    private void goNext() {

       Register_Activity.globalAdminName =adminNameHere;

       Register_Activity.globaladminPhone =adminPhoneHere;




        Toast.makeText(getContext(),"admin success", Toast.LENGTH_SHORT).show();


    }
}
