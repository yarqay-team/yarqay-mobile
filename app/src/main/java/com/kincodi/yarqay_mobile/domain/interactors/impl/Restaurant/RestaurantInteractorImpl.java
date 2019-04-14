package com.kincodi.yarqay_mobile.domain.interactors.impl.Restaurant;

import android.util.Log;

import com.kincodi.yarqay_mobile.domain.executor.Executor;
import com.kincodi.yarqay_mobile.domain.executor.MainThread;
import com.kincodi.yarqay_mobile.domain.interactors.GetListRestaurantInteractor;
import com.kincodi.yarqay_mobile.domain.interactors.base.AbstractInteractor;
import com.kincodi.yarqay_mobile.domain.model.Restaurant;
import com.kincodi.yarqay_mobile.storage.RestaurantRepositoryImpl;

import java.util.List;

import retrofit2.Response;

public class RestaurantInteractorImpl extends AbstractInteractor implements GetListRestaurantInteractor {

    private RestaurantRepositoryImpl mRestaurantRepositoryImpl;
    private MainThread mMainThread;
    private GetListRestaurantInteractor.Callback mCallback;

    public RestaurantInteractorImpl(Executor threadExecutor,
                                    MainThread mainThread,
                                    GetListRestaurantInteractor.Callback callback,
                                    RestaurantRepositoryImpl restaurantRepository
                                    ) {
        super(threadExecutor, mainThread);
        mRestaurantRepositoryImpl = restaurantRepository;
        mMainThread = mainThread;
        mCallback = callback;
    }

    @Override public void run() {
        Response response = mRestaurantRepositoryImpl.list();
        if (response!=null) {
            if (response.isSuccessful()){
                List<Restaurant> restaurants = (List<Restaurant>) response.body();
                onSuccess(restaurants);
            } else {
                onFailed("A ocurrido un error");
            }
        } else{
            onFailed("Intente nuevamente");
        }
    }
    private void onSuccess(final List<Restaurant> restaurants) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onGotRestaurant(restaurants);
            }
        });
    }
    private void onFailed(final String message) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onFailedGetRestaurant(message);
            }
        });
    }
}
