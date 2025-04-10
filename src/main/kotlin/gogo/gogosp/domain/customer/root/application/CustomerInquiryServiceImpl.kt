package gogo.gogosp.domain.customer.root.application

import gogo.gogosp.domain.customer.root.application.dto.WriteCustomerInquiryReqDto
import gogo.gogosp.global.util.UserContextUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerInquiryServiceImpl(
    private val userUtil: UserContextUtil,
    private val customerInquiryProcessor: CustomerInquiryProcessor
): CustomerInquiryService {

    @Transactional
    override fun writeInquiry(dto: WriteCustomerInquiryReqDto) {
        val student = userUtil.getCurrentStudent()
        customerInquiryProcessor.saveCustomerInquiry(dto, student)
    }
}