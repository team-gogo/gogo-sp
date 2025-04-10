package gogo.gogosp.domain.customer.root.application

import gogo.gogosp.global.error.SpException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class CustomerInquiryValidator {

    fun validPageAndSize(page: Int, size: Int) {
        if (page < 0 || size < 0) {
            throw SpException("page와 size는 음수일 수 없습니다.", HttpStatus.BAD_REQUEST.value())
        }
    }
}