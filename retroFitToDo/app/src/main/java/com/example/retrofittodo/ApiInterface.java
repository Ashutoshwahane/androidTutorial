package com.example.retrofittodo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/todos")
    Call<List<ToDo>> getToDo();

    @GET("/todos/{id}")
    Call<ToDo> getToDoRoute(@Part("id") int id);

    @GET("/todos")
    Call<ToDo> getToDoQuery(@Query("userId") int userId, @Query("completed") Boolean completed);

    @POST("/todos")
    Call<ToDo> postTodo(@Body ToDo toDo);
}
