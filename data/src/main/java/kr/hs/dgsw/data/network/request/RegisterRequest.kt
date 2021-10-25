package kr.hs.dgsw.data.network.request

data class RegisterRequest(
    val id : String,
    val pw : String,
    val personalNumber : String,
    val name : String,
    val phoneNumber : String,
    val email : String,
    val nickname : String
)