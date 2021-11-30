package kr.hs.dgsw.data.base

data class BaseResponse<T>(
    val status: Int,
    val message: String,
    val data: T
)