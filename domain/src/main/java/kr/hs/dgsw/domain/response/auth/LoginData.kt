package kr.hs.dgsw.domain.response.auth

data class LoginData (
    val token: String,
    val easyPwIdx: String
)