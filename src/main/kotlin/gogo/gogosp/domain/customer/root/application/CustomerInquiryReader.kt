package gogo.gogosp.domain.customer.root.application

import gogo.gogosp.domain.customer.root.application.dto.GetCustomerInquiryListResDto
import gogo.gogosp.domain.customer.root.persistence.CustomerInquiryRepository
import org.springframework.data.domain.PageRequest

import org.springframework.stereotype.Component
@Component
class CustomerInquiryReader(
    private val customerInquiryRepository: CustomerInquiryRepository
) {

    fun readCustomerInquiryPage(page: Int, size: Int): GetCustomerInquiryListResDto {
        val pageRequest = PageRequest.of(page, size)
        return customerInquiryRepository.queryCustomerInquiry(pageRequest, size)
    }
}

