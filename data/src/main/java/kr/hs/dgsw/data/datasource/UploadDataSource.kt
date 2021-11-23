package kr.hs.dgsw.data.datasource

import kr.hs.dgsw.data.base.BaseDataSource
import kr.hs.dgsw.data.network.remote.UploadRemote
import kr.hs.dgsw.data.network.service.UploadService
import okhttp3.MultipartBody

class UploadDataSource(override val remote: UploadRemote, override val cache: UploadService) :
    BaseDataSource<UploadRemote, UploadService>() {

        fun postImage(postImage : MultipartBody.Part) = remote.postFiles(postImage)
}