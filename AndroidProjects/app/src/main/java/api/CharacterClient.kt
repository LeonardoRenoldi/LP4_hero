package api

import model.Character
import model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import utils.RetrofitClient

class CharacterClient {

    fun createCharacter(id:String, character: Character): Character? {
        return  RetrofitClient.getRetrofit()
            .create(CharacterService::class.java)
            .createCharacter(id, character)
            .execute()
            .body()
    }
    fun getCharacter(id: String): List<Character>? {
        return RetrofitClient.getRetrofit()
            .create(CharacterService::class.java)
            .getCharacters(id)
            .execute()
            .body()
    }

    interface CharacterService {

        @GET("api/character/{id}")
        fun getCharacters(
            @Path("id") id: String,
        ): Call<List<Character>>

        @POST("api/character/{id}")
        fun createCharacter(
            @Path("id") id: String,
            @Body character: Character
        ): Call<Character>

        //:todo fazer o delete endpoint

    }

    interface UserService {
        @GET("api/user/{id}")
        fun getUser(
            @Path("id") id: String,
        ):Call<List<User>>

        @POST("api/login")
        fun saveUser(
            @Path("id") id: String,
        ):Call<User>
    }
}