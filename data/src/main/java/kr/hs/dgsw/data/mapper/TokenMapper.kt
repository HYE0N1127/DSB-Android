package kr.hs.dgsw.data.mapper

import kr.hs.dgsw.data.base.BaseEntityMapper
import kr.hs.dgsw.domain.response.auth.LoginData
import kr.hs.dgsw.domain.entity.Token

class TokenMapper: BaseEntityMapper<Token, LoginData> {
    override fun mapToModel(entity: LoginData): Token {
        return Token(
            entity.token,
            entity.easyPwIdx
        )
    }

    override fun mapToEntity(model: Token): LoginData {
        return LoginData(
            model.token,
            model.easyPwIdx
        )
    }
}