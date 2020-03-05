package com.cybernerd.cypherx.model

data class DepartmentResponse(
    val id : String,
    val name : String,
    val description : String,
    val is_active : Boolean
)

class WrapperDepartmentResponse(
    val result : List<DepartmentResponse>,
    val count : Int,
    val page_size : Int
)


