package com.kodcu.javaday.dto.request;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonTypeName("individual")
public class CreateIndTicketRequestDto extends CreateTicketRequestDto{
    @Pattern(regexp = "[1-9]{1}[0-9]{9}[02468]{1}$")
    private String nationalId;
    @NotBlank
    private String invoiceAddress;
    @NotBlank
    private String city;
}
