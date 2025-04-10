package gogo.gogosp.domain.customer.root.application.dto

import jakarta.validation.constraints.Size
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
