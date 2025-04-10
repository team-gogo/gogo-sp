package gogo.gogosp.domain.customer.root.application

import gogo.gogosp.domain.customer.root.application.dto.WriteCustomerInquiryReqDto
import gogo.gogosp.domain.customer.root.persistence.CustomerInquiry
import gogo.gogosp.domain.customer.root.persistence.CustomerInquiryRepository
import gogo.gogosp.global.internal.student.stub.StudentByIdStub
import org.springframework.stereotype.Component

@Component
class CustomerInquiryProcessor(
    private val customerInquiryRepository: CustomerInquiryRepository
) {

    fun saveCustomerInquiry(dto: WriteCustomerInquiryReqDto, student: StudentByIdStub) {
        val customerInquiry = CustomerInquiry(
            studentId = student.studentId,
            title = dto.title,
            content = dto.content,
            isReading = false,
            isOpening = dto.isOpening,
        )

        customerInquiryRepository.save(customerInquiry)
    }

}