package com.kincodi.yarqay_mobile.presentation.presenters.impl.Restaurant;

import com.kincodi.yarqay_mobile.domain.executor.Executor;
import com.kincodi.yarqay_mobile.domain.executor.MainThread;
import com.kincodi.yarqay_mobile.domain.interactors.GetListRestaurantInteractor;
import com.kincodi.yarqay_mobile.domain.interactors.impl.Restaurant.RestaurantInteractorImpl;
import com.kincodi.yarqay_mobile.domain.model.Restaurant;
import com.kincodi.yarqay_mobile.presentation.presenters.RestaurantPresenter;
import com.kincodi.yarqay_mobile.presentation.presenters.base.AbstractPresenter;
import com.kincodi.yarqay_mobile.storage.RestaurantRepositoryImpl;

import java.util.List;

public class RestaurantPresenterImpl extends AbstractPresenter
        implements RestaurantPresenter,GetListRestaurantInteractor.Callback {
    private RestaurantRepositoryImpl mRestaurantRepository;
    private RestaurantPresenter.View mView;

    public RestaurantPresenterImpl(Executor executor,
                                   MainThread mainThread,
                                   RestaurantRepositoryImpl restaurantRepository,
                                   RestaurantPresenter.View view) {
        super(executor, mainThread);
        mRestaurantRepository = restaurantRepository;
        mView = view;
    }
    @Override public void onGotRestaurant(List<Restaurant> restaurants) {
        mView.onSuccessGotRestaurant(restaurants);
    }
    @Override public void onFailedGetRestaurant(String message) {
        mView.onFailedGotRestaurant(message);
    }
    @Override public void getRestaurant() {

        RestaurantInteractorImpl interactor = new RestaurantInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mRestaurantRepository);
        interactor.execute();
    }
}
