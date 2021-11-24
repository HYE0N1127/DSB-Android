package kr.hs.dgsw.domain.request.auth

data class RegisterRequest(
    val id : String,
    val password : String,
    val name : String,
    val nickname : String,
    val phone : String,
    val birth : String,
    val profileImage : String
)