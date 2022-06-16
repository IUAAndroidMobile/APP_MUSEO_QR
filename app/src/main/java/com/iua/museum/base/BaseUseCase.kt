package com.iua.museum.base

import android.util.Log
import com.iua.museum.base.support.BaseApiErrorHandler
import com.iua.museum.base.support.BaseResultWrapper
import retrofit2.HttpException
import java.util.concurrent.CancellationException

abstract class BaseUseCase<RequestType, ResponseType>() where ResponseType : Any {

    private val apiErrorHandle = BaseApiErrorHandler()

    abstract suspend fun run(params: RequestType): ResponseType

    suspend fun invoke(
            params: RequestType
    ): BaseResultWrapper<ResponseType> {
        return try {
            val result = run(params)
            Log.d(TAG, "Success Response: $result")
            BaseResultWrapper.ApiSuccess(result)
        } catch (e: CancellationException) {
            Log.d(TAG, "Error: $e")
            BaseResultWrapper.ApiError(apiErrorHandle.traceErrorException(e))
        } catch (e: HttpException) {
            //400 errors
            Log.d(TAG, "Error: $e cause: ${e.cause}")
            BaseResultWrapper.ApiError(apiErrorHandle.traceErrorException(e))
        } catch (e: Exception) {
            Log.d(TAG, "Error 3: $e cause: ${e.cause}")
            BaseResultWrapper.ApiError(apiErrorHandle.traceErrorException(e))
        }
    }

    companion object {
        private val TAG = BaseUseCase::class.java.name
    }

}
