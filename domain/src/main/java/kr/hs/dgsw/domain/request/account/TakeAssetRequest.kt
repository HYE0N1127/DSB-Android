package kr.hs.dgsw.domain.request.account

data class TakeAssetRequest(
    val receiveAccountNum: String,
    val receiveAccountPw: String,
    val sendAccountNum: String,
    val transactionPay: Int
)