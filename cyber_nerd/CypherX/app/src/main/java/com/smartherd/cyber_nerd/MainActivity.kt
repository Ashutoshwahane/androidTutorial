package com.cybernerd.cypherx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cybernerd.cypherx.model.CypherXApi
import com.cybernerd.cypherx.model.Department
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // retrofit builder
        // objects to call

        val retrofit = Retrofit.Builder()
            .baseUrl("https://ashutoshwahane.github.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val cypherXApi = retrofit.create(CypherXApi::class.java)
        val department_call:Call<List<Department>> = cypherXApi.getDepartment()

        department_call.enqueue(object :Callback<List<Department>>{
            override fun onFailure(call: Call<List<Department>>, t: Throwable) {
                Log.e(" Something went wrong",t.message.toString())
            }

            override fun onResponse(
                call: Call<List<Department>>,
                response: Response<List<Department>>
            ) {
               val departments:List<Department> = response.body()!!
               val stringBuilder = StringBuilder()

                for(department in departments){
                    stringBuilder.append(department.department_id)
                    stringBuilder.append("\n")
                    stringBuilder.append(department.department_name)
                    stringBuilder.append("\n")
                    stringBuilder.append(department.description)
                    stringBuilder.append("\n")
                }

                textview_title.text = stringBuilder
            }
        })

    }
}

