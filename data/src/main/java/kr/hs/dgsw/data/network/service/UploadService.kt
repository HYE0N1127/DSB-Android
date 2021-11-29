package kr.hs.dgsw.data.network.service

import io.reactivex.Single
import kr.hs.dgsw.domain.response.Response
import okhttp3.MultipartBody
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadService {

    @POST("/upload")
    fun postImage(
        @Part file: MultipartBody.Part
    ) : Single<retrofit2.Response<Response<String>>>
}