package com.kincodi.yarqay_mobile.threading;

import android.os.Handler;
import android.os.Looper;

import com.kincodi.yarqay_mobile.domain.executor.MainThread;


public class MainThreadImpl implements MainThread {

    private static MainThread sMainThread;
    private Handler mHandler;

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static MainThread getInstance(){
        if (sMainThread==null){
            sMainThread = new MainThreadImpl();
        }
        return sMainThread;
    }
    private MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }
}
