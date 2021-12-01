package kr.hs.dgsw.domain.entity

data class Account(
    val accountNum : String,
    val name : String,
    val password : String,
    val pay : Int,
    val userId : String
)
