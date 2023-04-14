package api

import com.google.gson.JsonObject
import model.User
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface endPoint {
    @FormUrlEncoded
    @Headers
    @POST
   fun autenticacao(email : String, password: String) : Call<User>


}