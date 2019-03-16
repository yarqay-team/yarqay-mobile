package com.kincodi.yarqay_mobile.presentation.presenters;


import com.kincodi.yarqay_mobile.presentation.ui.BaseView;

public interface LoginUserPresenter {

    interface View extends BaseView {
        void onLogged();
        void onFailed(String message);
        void loginNormal();
    }
    void login(String email, String password);
}
