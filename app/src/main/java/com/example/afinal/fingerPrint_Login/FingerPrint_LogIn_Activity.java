package com.example.afinal.fingerPrint_Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.afinal.R;

public class FingerPrint_LogIn_Activity extends AppCompatActivity implements FinalStringResult{

    private TextView textViewMessage;
    private Button buttonLogIn, buttonSelectAdmin;

    private Presenter_FingerPrint presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessage =  findViewById(R.id.logIn_activity_textView_ID);
        buttonLogIn = findViewById(R.id.logIn_activity_button1_ID);
        buttonSelectAdmin = findViewById(R.id.logIn_activity_button2_ID);

        //when we select log in, should invoke fingerprint reader.

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //need to rewrite later, need to assume presenter dont know its a context
                //better sent interface like view, lifecycle dependencies issue
                textViewMessage.setText("checking fingerprint");

                Log.i("checkk flow: ","1");

                presenter = new Presenter_FingerPrint(FingerPrint_LogIn_Activity.this);

                Log.i("checkk flow: ","2");
                presenter.registerNow();

            }
        });




    }

    @Override
    public void resultFingerPrint(String result) {


        //this is weird implementation

        Log.i("checkk flow: ","3");
        presenter.getResult();
        Log.i("checkk flow: ","4");
        textViewMessage.setText(result);
    }
}
