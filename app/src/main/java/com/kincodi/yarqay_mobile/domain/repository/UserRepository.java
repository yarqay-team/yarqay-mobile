package com.kincodi.yarqay_mobile.domain.repository;


import com.kincodi.yarqay_mobile.domain.model.User;

import retrofit2.Response;


public interface UserRepository {
    Response updateFireBaseId(String fireBaseId, String oldFireBaseId);

    Response register(User user);
    Response login(User user);
    Response loginOAuth(User user);
}
