package model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("Senha")
    val password: String


)





