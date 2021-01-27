package com.example.clase201.network

import com.example.clase201.User
import com.example.clase201.network.responses.UserResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

object ApiClient{
    // retrofit doc https://square.github.io/retrofit/
    //json to kotlin class plugin en jetbrains ALT + K
    //https://docs.github.com/en/rest/reference/users#list-users
    private const val API_BASE_URL = " https://api.github.com/"

    private var mInterface : AppService
    private var mRetrofitAdapter : Retrofit

    init{
        mRetrofitAdapter =
            Retrofit
                .Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .connectTimeout(50, TimeUnit.SECONDS)
                        .readTimeout(50, TimeUnit.SECONDS)
                        .addInterceptor(
                            HttpLoggingInterceptor()
                                .setLevel(HttpLoggingInterceptor.Level.BODY)
                        )
                        .build()
                )
                .build()

        mInterface = mRetrofitAdapter.create(AppService::class.java)
    }

    fun getServiceClient() = mInterface

    interface AppService{
        @GET("users")
        fun getUsers(): Call<List<User>>

        @GET("users/{username}")//endpoint
        fun getUserDetails(@Path("username") username:String): Call<UserResponse>
    }
}