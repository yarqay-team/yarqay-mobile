package com.kincodi.yarqay_mobile.presentation.presenters.impl;

import com.kincodi.yarqay_mobile.domain.executor.Executor;
import com.kincodi.yarqay_mobile.domain.executor.MainThread;
import com.kincodi.yarqay_mobile.presentation.presenters.base.AbstractPresenter;
import com.kincodi.yarqay_mobile.storage.UserRepositoryImpl;


public class UpdateTokenFireBasePresenterImpl extends AbstractPresenter  {
    private UserRepositoryImpl userRepository = new UserRepositoryImpl();
    public UpdateTokenFireBasePresenterImpl(Executor executor, MainThread mainThread){
        super(executor,mainThread);
    }

}
