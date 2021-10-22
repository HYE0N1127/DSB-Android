package kr.hs.dgsw.domain.model

data class Account(
    val accountName : String,       // 계좌 이름
    val balance : Int,      // 계좌 잔액
    val accountProfileImage : String
)
