package com.kincodi.yarqay_mobile.domain.repository;

import com.kincodi.yarqay_mobile.domain.model.Restaurant;

import retrofit2.Response;

public interface RestaurantRepository {
    Response list();
}
