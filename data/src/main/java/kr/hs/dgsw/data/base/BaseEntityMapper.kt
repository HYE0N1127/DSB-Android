package kr.hs.dgsw.data.base

interface BaseEntityMapper <M, E> {

    fun mapToModel(entity: E): M

    fun mapToEntity(model: M): E
}