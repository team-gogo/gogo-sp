package gogo.gogosp.domain.customer.root.application

import gogo.gogosp.domain.customer.root.application.dto.GetCustomerInquiryListResDto
import gogo.gogosp.domain.customer.root.application.dto.WriteCustomerInquiryReqDto
import gogo.gogosp.global.util.UserContextUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CustomerInquiryServiceImpl(
    private val userUtil: UserContextUtil,
    private val customerInquiryProcessor: CustomerInquiryProcessor,
    private val customerInquiryReader: CustomerInquiryReader,
    private val customerInquiryValidator: CustomerInquiryValidator
): CustomerInquiryService {

    @Transactional
    override fun writeInquiry(dto: WriteCustomerInquiryReqDto) {
        val student = userUtil.getCurrentStudent()
        customerInquiryProcessor.saveCustomerInquiry(dto, student)
    }

    @Transactional(readOnly = true)
    override fun getInquiryList(page: Int, size: Int): GetCustomerInquiryListResDto {
        customerInquiryValidator.validPageAndSize(page, size)
        return customerInquiryReader.readCustomerInquiryPage(page, size)
    }
}