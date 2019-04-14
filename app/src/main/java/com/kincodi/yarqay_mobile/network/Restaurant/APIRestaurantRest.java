package com.kincodi.yarqay_mobile.network.Restaurant;

import com.kincodi.yarqay_mobile.domain.model.Restaurant;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRestaurantRest {
    @GET("/restaurants/list")
    Call<List<Restaurant>> getRestaurant();

}
