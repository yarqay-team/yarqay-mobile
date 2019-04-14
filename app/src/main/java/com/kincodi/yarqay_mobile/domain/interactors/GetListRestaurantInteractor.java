package com.kincodi.yarqay_mobile.domain.interactors;

import com.kincodi.yarqay_mobile.domain.model.Restaurant;

import java.util.List;

public interface GetListRestaurantInteractor {
    interface Callback {
        void onGotRestaurant(List<Restaurant> restaurants);
        void onFailedGetRestaurant(String message);
    }
}
