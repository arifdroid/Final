package com.example.afinal.fingerPrint_Login.fingerprint_login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.afinal.R;

public class Login_Select_Action_Fragment extends Fragment {

    private Context mContext;

    private FloatingActionButton floatButton_Admin_1,floatButton_Admin_2, floatButton_Reg_Admin, floatButton_Reg_User,
                                floatButton_Admin_1

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //        return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.floatingbutton_fragment_select, container,false);

        mContext = container.getContext();







        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        //data we want to sent back


    }
}
