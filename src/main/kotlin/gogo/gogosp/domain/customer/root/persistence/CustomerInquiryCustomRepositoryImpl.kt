package gogo.gogosp.domain.customer.root.persistence

import com.querydsl.jpa.impl.JPAQueryFactory
import gogo.gogosp.domain.customer.root.application.dto.AuthorDto
import gogo.gogosp.domain.customer.root.application.dto.CustomerInquiryDto
import gogo.gogosp.domain.customer.root.application.dto.GetCustomerInquiryListResDto
import gogo.gogosp.domain.customer.root.application.dto.PagingDto
import gogo.gogosp.domain.customer.root.persistence.QCustomerInquiry.customerInquiry
import gogo.gogosp.global.internal.student.api.StudentApi
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class CustomerInquiryCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
    private val studentApi: StudentApi
): CustomerInquiryCustomRepository {

    override fun queryCustomerInquiry(pageable: Pageable, size: Int): GetCustomerInquiryListResDto {
        val customerInquiryList = queryFactory
            .selectFrom(customerInquiry)
            .orderBy(
                customerInquiry.customerInquiryId.desc()
            )
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        val studentIds = customerInquiryList.map {it.studentId}.toSet().toList()

        val students = studentApi.queryStudentsByStudentIds(studentIds).students

        val customerInquiryDto = customerInquiryList.map { customerInquiry ->
            val student = students.find { it.studentId == customerInquiry.studentId }!!

            CustomerInquiryDto(
                customerInquiryId = customerInquiry.customerInquiryId,
                title = customerInquiry.title,
                content = customerInquiry.content,
                isReading = customerInquiry.isReading,
                isOpening = customerInquiry.isOpening,
                authorDto = AuthorDto(
                    studentId = student.studentId,
                    name = student.name,
                    classNumber = student.classNumber,
                    studentNumber = student.studentNumber
                )
            )
        }

        val totalElement = customerInquiryList.size

        val totalPage = if (totalElement % size == 0) {
            totalElement / size
        } else {
            totalElement / size + 1
        }

        val pagingDto = PagingDto(totalPage, totalElement)

        return GetCustomerInquiryListResDto(pagingDto, customerInquiryDto)
    }
}