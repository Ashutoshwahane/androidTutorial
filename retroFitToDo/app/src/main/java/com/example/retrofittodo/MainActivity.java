package com.example.retrofittodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getToDo(View view) {

        Call<List<ToDo>> call = apiInterface.getToDo();
        call.enqueue(new Callback<List<ToDo>>() {
            @Override
            public void onResponse(Call<List<ToDo>> call, Response<List<ToDo>> response) {
                Log.e(TAG, "onResponse: "+ response.body() );

            }

            @Override
            public void onFailure(Call<List<ToDo>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getLocalizedMessage() );
            }
        });

    }

    public void getTodoRoute(View view) {
        Call<ToDo> toDoRoute = apiInterface.getToDoRoute(1);
            toDoRoute.enqueue(new Callback<ToDo>() {
                @Override
                public void onResponse(Call<ToDo> call, Response<ToDo> response) {
                    Log.e(TAG, "onResponse: "+ response.body());

                }

                @Override
                public void onFailure(Call<ToDo> call, Throwable t) {
                    Log.e(TAG, "onFailure: "+ t.getLocalizedMessage() );

                }
            });

    }

    public void getToDoQuery(View view) {
        Call<ToDo> todoQuery = apiInterface.getToDoQuery(2,false);
        todoQuery.enqueue(new Callback<ToDo>() {
            @Override
            public void onResponse(Call<ToDo> call, Response<ToDo> response) {
                Log.e(TAG, "onResponse: "+response.body() );
            }

            @Override
            public void onFailure(Call<ToDo> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getLocalizedMessage() );
            }
        });
    }

    public void PostToDo(View view) {
        ToDo toDo = new ToDo(3, "get me a milk" ,false);
        Call<ToDo> toDoPostCall = apiInterface.postTodo(toDo);
        toDoPostCall.enqueue(new Callback<ToDo>() {
            @Override
            public void onResponse(Call<ToDo> call, Response<ToDo> response) {
                Log.e(TAG, "onResponse: "+ response.body() );
            }

            @Override
            public void onFailure(Call<ToDo> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getLocalizedMessage() );

            }
        });
    }
}
