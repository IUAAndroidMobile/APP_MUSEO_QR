package com.tecno_moviles.museum.base.support

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * This class trace exceptions(api call or parse data or connection errors) &
 * depending on what exception returns [ErrorModel]
 * */
class BaseApiErrorHandler {

    suspend fun traceErrorException(exception: Exception?): ErrorModel {
        val errorModel: ErrorModel? = when (exception) {

            // if throwable is an instance of HttpException
            // then attempt to parse error data from response body
            is HttpException -> {
                // handle UNAUTHORIZED situation (when token expired)
                if (exception.code() == 401 || exception.code() == 403) {
                    ErrorModel(exception.message(), exception.code(), ErrorModel.ErrorStatus.UNAUTHORIZED)
                } else if (exception.code() == 422) {
                    val errorBody = exception.response()?.errorBody()?.stringSuspending()
                    ErrorModel(errorBody, exception.code(), ErrorModel.ErrorStatus.AGORA_CUSTOM_ERROR)
                } else {
                    getHttpError(exception.response()?.errorBody())
                }
            }

            // handle api call timeout error
            is SocketTimeoutException -> {
                ErrorModel(exception.message, ErrorModel.ErrorStatus.TIMEOUT)
            }

            // handle connection error
            is IOException -> {
                ErrorModel(exception.message, ErrorModel.ErrorStatus.NO_CONNECTION)
            }
            else -> null
        }
        return errorModel ?: ErrorModel("No Defined Error!", 0, ErrorModel.ErrorStatus.BAD_RESPONSE)
    }

    /**
     * attempts to parse http response body and get error data from it
     *
     * @param body retrofit response body
     * @return returns an instance of [ErrorModel] with parsed data or NOT_DEFINED status
     */
    private fun getHttpError(body: ResponseBody?): ErrorModel {
        return try {
            // use response body to get error detail
            ErrorModel(body.toString(), 400, ErrorModel.ErrorStatus.BAD_RESPONSE)
        } catch (e: Throwable) {
            e.printStackTrace()
            ErrorModel(message = e.message, errorStatus = ErrorModel.ErrorStatus.NOT_DEFINED)
        }

    }
}

//TODO: See this how is working
@Suppress("BlockingMethodInNonBlockingContext")
suspend fun ResponseBody.stringSuspending() =
    withContext(Dispatchers.IO) { string() }
