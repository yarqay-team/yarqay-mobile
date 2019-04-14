package com.kincodi.yarqay_mobile.presentation.presenters;

import com.kincodi.yarqay_mobile.domain.model.Restaurant;
import com.kincodi.yarqay_mobile.presentation.ui.BaseView;

import java.util.List;

public interface RestaurantPresenter {
    interface View extends BaseView {
        void onSuccessGotRestaurant(List<Restaurant> restaurants);
        void onFailedGotRestaurant(String message);
    }
    void getRestaurant();
}
