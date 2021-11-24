package kr.hs.dgsw.domain.request.auth

data class LoginRequest(
    val id: String,
    val password: String
)
