package com.cybernerd.cypherx.api
import com.cybernerd.cypherx.model.DepartmentResponse
import com.cybernerd.cypherx.model.WrapperDepartmentResponse
import retrofit2.Call
import retrofit2.http.GET

interface API_Calls {

    @GET("test.json")
    fun getAllDepartment() : Call<List<DepartmentResponse>>

    }

//    @GET("paginated.json")
//    fun getAllDepartment() : Call<WrapperDepartmentResponse>
//    }
