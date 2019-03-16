package com.kincodi.yarqay_mobile.presentation.presenters.base;


import com.kincodi.yarqay_mobile.domain.executor.Executor;
import com.kincodi.yarqay_mobile.domain.executor.MainThread;

public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(
            Executor executor,
            MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
