package com.kodcu.javaday.dto.request;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonTypeName("company")
public class CreateCompTicketRequestDto extends CreateTicketRequestDto{

    private String companyName;
    @NotBlank
    private String invoiceAddress;
    private String city;
    private boolean isKDVLiability;
    @Pattern(regexp = "^[0-9]{10}$")
    private String taxId;
    private String taxOffice;
}
