package kr.hs.dgsw.data.repository

import io.reactivex.Single
import kr.hs.dgsw.data.datasource.UploadDataSource
import kr.hs.dgsw.domain.repository.UploadRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class UploadRepositoryImpl(private val uploadDataSource: UploadDataSource) : UploadRepository {

    override fun uploadImage(image: File?): Single<String> {

    }
}