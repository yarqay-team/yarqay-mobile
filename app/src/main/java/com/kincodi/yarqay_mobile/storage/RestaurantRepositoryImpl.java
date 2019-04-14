package com.kincodi.yarqay_mobile.storage;

import android.util.Log;

import com.kincodi.yarqay_mobile.domain.model.Restaurant;
import com.kincodi.yarqay_mobile.domain.repository.RestaurantRepository;
import com.kincodi.yarqay_mobile.network.RestClient;
import com.kincodi.yarqay_mobile.network.Restaurant.APIRestaurantRest;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    private APIRestaurantRest API;
    public RestaurantRepositoryImpl () {
        RestClient mRestClient = new RestClient();
        API = mRestClient.getService(APIRestaurantRest.class);
    }

    @Override
    public Response list() {
        try {
            Call call = API.getRestaurant();
            Response<List<Restaurant>> result = call.execute();
            Log.e("dadada", String.valueOf(result));
            return result;
        } catch (IOException e) {
            Log.e("Error Exception",e.toString());
        }
        return null;
    }
}
