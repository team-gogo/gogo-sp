package gogo.gogosp.domain.customer.root.application

import gogo.gogosp.domain.customer.root.application.dto.WriteCustomerInquiryReqDto

interface CustomerInquiryService {
    fun writeInquiry(dto: WriteCustomerInquiryReqDto)
}