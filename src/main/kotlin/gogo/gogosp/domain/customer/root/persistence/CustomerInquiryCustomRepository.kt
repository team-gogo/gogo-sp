package gogo.gogosp.domain.customer.root.persistence

import gogo.gogosp.domain.customer.root.application.dto.GetCustomerInquiryListResDto
import org.springframework.data.domain.Pageable

interface CustomerInquiryCustomRepository {
    fun queryCustomerInquiry(pageable: Pageable, size: Int): GetCustomerInquiryListResDto
}