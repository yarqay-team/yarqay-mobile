package com.kincodi.yarqay_mobile.storage;

import android.util.Log;


import com.kincodi.yarqay_mobile.domain.model.User;
import com.kincodi.yarqay_mobile.domain.repository.UserRepository;
import com.kincodi.yarqay_mobile.network.RestClient;
import com.kincodi.yarqay_mobile.network.User.APIUserRest;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;


public class UserRepositoryImpl implements UserRepository {

    private RestClient mRestClient;
    private APIUserRest API;

    public UserRepositoryImpl( ) {
        mRestClient  = new RestClient();
        API=mRestClient.getService(APIUserRest.class);
    }

    @Override
    public Response updateFireBaseId(String fireBaseId, String oldFireBaseId) {
        try{
            Call call = API.updateFireBaseId(fireBaseId);
            Response<ResponseBody> result =  call.execute();
            return result;
        }catch (IOException e){
            Log.e("Error Exception",e.toString());
        }

        return null;
    }

    @Override
    public Response register(User user) {
        try{
            Call call = API.register(user);
            Log.d("Register", String.valueOf(user));
            Response<User> result = call.execute();
            return result;
        }catch (IOException e){
            Log.e("Error Exception",e.toString());
        }
        return null;
    }

    @Override
    public Response login(User user) {
        try{
            Call call =  API.login(user);
            Response<User> result = call.execute();
            return result;
        }catch (IOException e){
            Log.e("Error Exception",e.toString());

        }
        return null;

    }

    @Override
    public Response loginOAuth(User user) {
        return null;
    }
}
