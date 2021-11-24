package kr.hs.dgsw.domain.repository

import io.reactivex.Single
import java.io.File

interface UploadRepository {
    fun uploadImage(image : File?): Single<String>
}