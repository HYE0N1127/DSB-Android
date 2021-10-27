package kr.hs.dgsw.data.network.response

data class LoginResponse (
    val token: String,
    val simpleLoginToken: String
)