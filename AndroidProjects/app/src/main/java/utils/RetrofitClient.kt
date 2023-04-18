package utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://fundatec.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}