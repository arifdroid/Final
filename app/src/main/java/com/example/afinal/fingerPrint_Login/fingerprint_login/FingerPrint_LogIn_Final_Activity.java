package com.example.afinal.fingerPrint_Login.fingerprint_login;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afinal.R;

public class FingerPrint_LogIn_Final_Activity extends AppCompatActivity implements FingerPrintFinal_View_Interface, View.OnClickListener {

    private FloatingActionButton floatButtonGetAction;
    private TextView textView;
    private ImageView imageView;

    private Login_Select_Action_Fragment fragment;

    private FingerPrintFinal_Presenter presenter;

    ConstraintLayout backColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print__log_in__final_);

        floatButtonGetAction = findViewById(R.id.logn_Final_floatingActionButtonID);

        floatButtonGetAction.setOnClickListener(this);

        textView = findViewById(R.id.login_final_textViewHereID);
        imageView = findViewById(R.id.login_final_imageViewID);
        textView.setText("click button below to log in");
        backColor = findViewById(R.id.backLayoutColourID);

        fragment = new Login_Select_Action_Fragment();



    }

    @Override
    public void onClick(View v) {

        backColor.setAlpha(0.05f);

        getSupportFragmentManager().beginTransaction()
        .replace(R.id.frameID,fragment)
        .addToBackStack("")
        .commit();


    }
}
