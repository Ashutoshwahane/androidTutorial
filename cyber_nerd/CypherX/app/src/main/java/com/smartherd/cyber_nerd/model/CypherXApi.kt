package com.cybernerd.cypherx.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface CypherXApi {


    @GET("/test.json")
    fun getDepartment(): Call<List<Department>>

    companion object{
        var BASE_URL = "https://ashutoshwahane.github.io/"

        fun create() : CypherXApi {

            val retrofit = Retrofit
        }
    }
}