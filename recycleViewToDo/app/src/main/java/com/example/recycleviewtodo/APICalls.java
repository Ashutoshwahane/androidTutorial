package com.example.recycleviewtodo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICalls {

    @GET("test.json")
    Call<List<modelClass>> getDepartment();
}
