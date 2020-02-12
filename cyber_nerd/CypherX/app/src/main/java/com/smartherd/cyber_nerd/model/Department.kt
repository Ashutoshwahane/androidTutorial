package com.cybernerd.cypherx.model

import com.google.gson.annotations.SerializedName

class Department(

    @SerializedName("id")
    val department_id : String,

    @SerializedName("name")
    val department_name : String,

    val description : String


)