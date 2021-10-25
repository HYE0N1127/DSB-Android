package kr.hs.dgsw.domain.entity

data class Account(
    val idx: Int,
    val accountName : String,       // 계좌 이름
    val balance : Int,      // 계좌 잔액
    val accountProfileImage : String
)
