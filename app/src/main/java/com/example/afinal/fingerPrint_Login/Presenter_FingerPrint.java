package com.example.afinal.fingerPrint_Login;


import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.util.Log;
import android.view.View;

import static android.support.v4.content.ContextCompat.getSystemService;


public class Presenter_FingerPrint {

    private FinalStringResult finalStringResult;

    private String resultFinal;

    public void getResult(){
        if(finalStringResult!=null) {

            Log.i("checkk flow: ","13");

            if(resultFinal!=null) {
                Log.i("checkk flow: ","14");
                finalStringResult.resultFingerPrint(resultFinal);
            }else {
                Log.i("checkk flow: ","15");
                finalStringResult.resultFingerPrint("fail first");
            }
        }
    }

    public void registerNow(){
        finalStringResult = (FinalStringResult) mContext;
    }

    private Context mContext;

    private FingerprintManager fingerprintManager;

    private Model_fingerPrint model_fingerPrint;

    //constructor
    public Presenter_FingerPrint(Context context){

        Log.i("checkk flow: ","5");

        this.mContext = context;
        checkSupportedDevice();

    }

    private void checkSupportedDevice() {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            //run
            Log.i("checkk flow: ","6");
           fingerprintManager = (FingerprintManager) mContext.getSystemService(Context.FINGERPRINT_SERVICE);

           model_fingerPrint =new Model_fingerPrint(mContext);

           if(model_fingerPrint!=null){

               Log.i("checkk flow: ","7");
               startFingerPrintAuth();
           }


        }else {
            //abort operation return

            Log.i("checkk flow: ","8");
            getResult();

        }
    }

    private void startFingerPrintAuth() {

        //how about we start listening, but we dont need live data,
        //we just need one time result.
        //but what if failed attempt, mistake fingerprint, need to try again.
        //loop 3 times to test, then force to try again with main button

        //we can setup interface result here.

        Log.i("checkk flow: ","9");

        model_fingerPrint.startAuthFingerPrint(fingerprintManager);
        Log.i("checkk flow: ","10");
        model_fingerPrint.setPassResult(new PassResult() {
            @Override
            public void passingResult(String result) {
                //this will run after result passed.

                Log.i("checkk flow: ","11");
                returnToRequest(result);

            }
        });






    }

    private void returnToRequest(String result) {

        //we could use same design, but we suppose to use same node presenter to call for result.

        Log.i("checkk flow: ","12");
          resultFinal=result;
    }


}
