package kr.hs.dgsw.dsb_android.navigator

interface AccountNavigator {
    // 송금 버튼 클릭 시 이동할 함수
    // TODO : 계좌 상세 페이지로 이동
    fun onClickRemittance()

    // 계좌 아이템 클릭 시에 이동할 함수
    // TODO : 송금 페이지로 이동
    fun onClickAccount()
}