package kr.hs.dgsw.domain.request

data class EasySignUpRequest(
    val userId: String,
    val easyPassword: String
)
