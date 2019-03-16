package com.kincodi.yarqay_mobile.network.User;



import com.kincodi.yarqay_mobile.domain.model.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface APIUserRest {

    @POST("/login")
    Call<User> login(@Body User user);

    @POST("/users")
    Call<User> register(@Body User user);

    @PUT("users/firebase-token")
    Call<ResponseBody> updateFireBaseId(@Query("firebaseToken") String firebaseToken);

}
