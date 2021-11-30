package kr.hs.dgsw.data.base

import io.reactivex.functions.Function
import org.json.JSONObject

abstract class BaseRemote<SV> {
    abstract val service:SV

    protected fun <T> getResponseData(): Function<retrofit2.Response<BaseResponse<T>>, T> {
        return Function{ response: retrofit2.Response<BaseResponse<T>> ->
            checkError(response)
            response.body()!!.data
        }
    }

    protected fun getResponseMessage(): Function<retrofit2.Response<BaseResponse<Any>>, String> {
        return Function { response: retrofit2.Response<BaseResponse<Any>> ->
            checkError(response)
            response.body()!!.message
        }
    }

    private fun checkError(response: retrofit2.Response<*>) {
        if(!response.isSuccessful){
            val errorBody = JSONObject(response.errorBody()!!.string())
            throw Throwable(errorBody.getString("message"))
        }
    }
}