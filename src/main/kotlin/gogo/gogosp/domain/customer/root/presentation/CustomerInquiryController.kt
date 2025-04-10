package gogo.gogosp.domain.customer.root.presentation

import gogo.gogosp.domain.customer.root.application.CustomerInquiryService
import gogo.gogosp.domain.customer.root.application.dto.GetCustomerInquiryListResDto
import gogo.gogosp.domain.customer.root.application.dto.WriteCustomerInquiryReqDto
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/sp")
class CustomerInquiryController(
    private val customerInquiryService: CustomerInquiryService
) {

    @PostMapping("/customer/inquiry")
    fun writeInquiry(
        @RequestBody @Valid dto: WriteCustomerInquiryReqDto
    ): ResponseEntity<Void> {
        customerInquiryService.writeInquiry(dto)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping("/customer")
    fun getInquiryList(
        @RequestParam(required = false, defaultValue = "0") page: Int,
        @RequestParam(required = false, defaultValue = "20") size: Int,
    ): ResponseEntity<GetCustomerInquiryListResDto> {
        val response = customerInquiryService.getInquiryList(page, size)
        return ResponseEntity.ok(response)
    }


}