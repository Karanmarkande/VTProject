package com.upu.vtproject.api;

import com.upu.vtproject.api.response.StudentResponse;
import com.upu.vtproject.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface ApiInterface {

  @GET(Constant.EndPoint.STUDENT)
    Call<StudentResponse> getStudents(
            @Header(Constant.ApiKey.AUTH) String authHeader);
  }
