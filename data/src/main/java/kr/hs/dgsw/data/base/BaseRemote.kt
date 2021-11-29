package kr.hs.dgsw.data.base

import io.reactivex.functions.Function
import kr.hs.dgsw.domain.response.Response
import org.json.JSONObject

abstract class BaseRemote<SV> {
    abstract val service:SV

    protected fun <T> getResponseData(): Function<retrofit2.Response<Response<T>>, T> {
        return Function{ response: retrofit2.Response<Response<T>> ->
            checkError(response)
            response.body()!!.data
        }
    }

    protected fun getResponseMessage(): Function<retrofit2.Response<Response<Any>>, String> {
        return Function { response: retrofit2.Response<Response<Any>> ->
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