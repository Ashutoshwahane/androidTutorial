package com.cybernerd.cypherx.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import com.cybernerd.cypherx.R
import com.cybernerd.cypherx.Utils.debug
import com.cybernerd.cypherx.adapter.RecycleAdapter
import com.cybernerd.cypherx.api.retrofitInstance
import com.cybernerd.cypherx.model.DepartmentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerAdapter = RecycleAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val cypherapi = retrofitInstance.getdepartment.getAllDepartment()
        cypherapi.enqueue(object : Callback<List<DepartmentResponse>> {
            override fun onResponse(call: Call<List<DepartmentResponse>>?, response: Response<List<DepartmentResponse>>?) {
                debug("${response?.body()}")
                if (response?.body() != null)
                    recyclerAdapter.setdepartment(response.body()!!)
            }

            override fun onFailure(call: Call<List<DepartmentResponse>>?, t: Throwable?) {

            }
        })
    }
}
