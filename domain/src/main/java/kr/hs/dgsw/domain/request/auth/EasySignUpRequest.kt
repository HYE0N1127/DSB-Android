package kr.hs.dgsw.domain.request.auth

data class EasySignUpRequest(
    val userId: String,
    val easyPassword: String
)
