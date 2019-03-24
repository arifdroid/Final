package com.example.afinal.fingerPrint_Login.test_mvp;

interface ThisView {
    //this is how we pass, we call from presenter.
    void onClearText();
    void onLogInResult(Boolean result, int code);

}
