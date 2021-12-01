package kr.hs.dgsw.domain.request.account

data class AddAccountRequest(
    val accountNum: String,
    val name: String,
    val password: String,
    val pay: Int
)