package gogo.gogosp.global.feign

import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder
import gogo.gogosp.global.error.SpException
import org.springframework.http.HttpStatus

class FeignClientErrorDecoder : ErrorDecoder {
    override fun decode(
        methodKey: String?,
        response: Response,
    ): Exception? {
        if (response.status() >= 400) {
            throw SpException("HTTP 통신 오류", HttpStatus.INTERNAL_SERVER_ERROR.value())
        }
        return FeignException.errorStatus(methodKey, response)
    }
}
