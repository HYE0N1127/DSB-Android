package kr.hs.dgsw.domain.request.auth

data class EasyLoginRequest(
    val idx: String,
    val easyPassword: String
)
