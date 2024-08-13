package com.upu.vtproject.api;

import com.upu.vtproject.api.response.LoginResponse;
import com.upu.vtproject.api.response.StudentResponse;
import com.upu.vtproject.utils.Constant;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface ApiInterface {

    @GET(Constant.EndPoint.STUDENT)
    Call<StudentResponse> getStudents(
            @Header(Constant.ApiKey.AUTH) String authHeader);


    @POST(Constant.EndPoint.LOGIN)
    Call<LoginResponse> login(
            @Body Map<String, Object> body

    );
}
