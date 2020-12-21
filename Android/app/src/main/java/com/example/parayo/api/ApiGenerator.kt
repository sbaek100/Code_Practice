package com.example.parayo.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* 우리가 사용할 인터페이스의 객체를 만들어 내기 위해서 사용하는 것ㅇ.ㅁ
*  */
class ApiGenerator {

    fun <T> generate(api: Class<T>) : T = Retrofit.Builder()
            .baseUrl(HOST).addConverterFactory(GsonConverterFactory.create())
            .client(httpClient()).build().create(api)

    // retrofit 과 연계를 위해 http 통신 객체를 만들어 내는 것임
    // 별도 Logging 을 통해서 통신 상황을 확인 가능함
    private fun httpClient() = OkHttpClient.Builder().apply {
        addInterceptor(httpLoggingIntercepter())
    }.build()

    private fun httpLoggingIntercepter() = HttpLoggingInterceptor().apply{
        level = HttpLoggingInterceptor.Level.BODY
    }

    companion object{
        // 개발 서버에 대한 IP 를 바라보는 것으로 함.
        // 안드로이드에서 같은 서버의 백엔드를 바라볼때는 10.0.2.2 IP 를 쓴다.
        const val HOST = "http://10.0.2.2:8080"
    }

}