package com.example.afinal.fingerPrint_Login.register;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.afinal.R;

public class Register_Activity extends AppCompatActivity {


    //https://www.youtube.com/watch?v=Asc4hU1iSTU&list=PLOzDKCBkR50Set8l8vzp4sWSumCy6Z6Nf&index=35&t=652s
    //private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_checkadmin:

                    return true;
                case R.id.navigation_registeruser:

                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.registration_navigationiD);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
