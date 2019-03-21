package com.example.afinal.fingerPrint_Login.register;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.afinal.R;

public class RegisterAdmin_Fragment extends Fragment implements OurView {

    private EditText editTextAdminName, editTextAdminPhone;

    private RegisterAdmin_Fragment_Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);

        editTextAdminName = container.findViewById(R.id.registerAdmin_editText_adminNameID);
        editTextAdminPhone = container.findViewById(R.id.registerAdmin_editText_adminPhoneID);

        presenter = new RegisterAdmin_Fragment_Presenter(this);

        String adminName = editTextAdminName.getText().toString();
        String adminPhone = editTextAdminPhone.getText().toString();

        checkAdminExist(adminName,adminPhone);



        return inflater.inflate(R.layout.register_admin_fragment,container,false);

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

        boolean notnull = checkInputExist(adminName,adminPhone);

        if(notnull){


        }else {


        }

    }
}
