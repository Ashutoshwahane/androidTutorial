package com.example.recycleviewtodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<modelClass> modelClasses = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


//        List<modelClass> modelClassList = new ArrayList<>();
//        modelClassList.add(new modelClass("ashutosh", "user 1"));
//        modelClassList.add(new modelClass("wills", "user 2"));
//        modelClassList.add(new modelClass("yeshu", "user 3"));
//        modelClassList.add(new modelClass("darshit", "user 4"));
//        modelClassList.add(new modelClass("vaibhav", "user 5"));
//        modelClassList.add(new modelClass("lucky", "user 6"));
//        modelClassList.add(new modelClass("harsh", "user 7"));
//        modelClassList.add(new modelClass("amit ", "user 8"));
//        modelClassList.add(new modelClass("rahul", "user 9"));
//        modelClassList.add(new modelClass("goldy", "user 10"));
//
//        Adapter adapter = new Adapter(modelClassList);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();

        getDepartment();
    }

    private void getDepartment() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ashutoshwahane.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APICalls apiCalls = retrofit.create(APICalls.class);
        Call<List<modelClass>> call = apiCalls.getDepartment();

        call.enqueue(new Callback<List<modelClass>>() {
            @Override
            public void onResponse(Call<List<modelClass>> call, Response<List<modelClass>> response) {
                assert response.body() != null;
                modelClasses = new ArrayList<>(response.body());
                adapter = new Adapter(MainActivity.this, modelClasses);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "200", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<modelClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "400", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
