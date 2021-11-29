package kr.hs.dgsw.domain.response

data class Response<T>(
    val status: Int,
    val message: String,
    val data: T
)