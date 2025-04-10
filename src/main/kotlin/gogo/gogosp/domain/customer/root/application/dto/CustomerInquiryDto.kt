package gogo.gogosp.domain.customer.root.application.dto

import jakarta.validation.constraints.Size
import org.aspectj.weaver.IntMap
import org.jetbrains.annotations.NotNull

data class WriteCustomerInquiryReqDto(
    @NotNull
    @Size(min = 1, max = 10)
    val title: String,
    @NotNull
    val content: String,
    @NotNull
    val isOpening: Boolean,
)

data class GetCustomerInquiryListResDto(
    val info: PagingDto,
    val inquiries: List<CustomerInquiryDto>
)

data class CustomerInquiryDto(
    val customerInquiryId: Long,
    val title: String,
    val content: String,
    val isReading: Boolean,
    val isOpening: Boolean,
    val authorDto: AuthorDto
)

data class PagingDto(
    val page: Int,
    val size: Int
)

data class AuthorDto(
    val studentId: Long,
    val name: String,
    val classNumber: Int,
    val studentNumber: Int,
)
