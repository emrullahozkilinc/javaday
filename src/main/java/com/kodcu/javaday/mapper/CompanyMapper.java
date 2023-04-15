package com.kodcu.javaday.mapper;


import com.kodcu.javaday.dto.request.CreateCompTicketRequestDto;
import com.kodcu.javaday.model.Company;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CompanyMapperImpl" , componentModel = "spring")
public interface CompanyMapper {
    Company toCompanyFromCreateCompTicketRequestDto(CreateCompTicketRequestDto createCompTicketRequestDto);
}
