package com.example.parayo.api

import com.example.parayo.api.request.SignupRequest
import com.example.parayo.api.response.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ParayoApi {

    @GET("/api/v1/hello")
    // 비동기 호출 지원을 위해서 suspend 를 사용함.
    suspend fun hello(): ApiResponse<String>
    companion object {
        val instance = ApiGenerator().generate(ParayoApi::class.java)
    }

    @POST("/api/v1/users")
    suspend fun signup(@Body signupRequest: SignupRequest): ApiResponse<Void>
}