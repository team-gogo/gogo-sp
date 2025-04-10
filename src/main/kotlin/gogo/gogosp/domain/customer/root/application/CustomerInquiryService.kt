package gogo.gogosp.domain.customer.root.application

import gogo.gogosp.domain.customer.root.application.dto.GetCustomerInquiryListResDto
import gogo.gogosp.domain.customer.root.application.dto.WriteCustomerInquiryReqDto

interface CustomerInquiryService {
    fun writeInquiry(dto: WriteCustomerInquiryReqDto)
    fun getInquiryList(page: Int, size: Int): GetCustomerInquiryListResDto
}