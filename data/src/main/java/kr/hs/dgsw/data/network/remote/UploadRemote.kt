package kr.hs.dgsw.data.network.remote

import kr.hs.dgsw.data.base.BaseRemote
import kr.hs.dgsw.data.network.service.UploadService
import okhttp3.MultipartBody

class UploadRemote(override val service: UploadService) : BaseRemote<UploadService>() {

    fun postFiles(postFiles: MultipartBody.Part) =
        service.postImage(postFiles).map(getResponseData())
}