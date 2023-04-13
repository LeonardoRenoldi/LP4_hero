package api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface endPoint {

    @GET("https://fundatec.herokuapp.com/herois")
    fun getHerois(): Call<JsonObject>

    @GET("https://fundatec.herokuapp.com/viloes")
    fun getViloes(): Call<JsonObject>


}