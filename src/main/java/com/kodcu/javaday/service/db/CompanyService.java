package com.kodcu.javaday.service.db;

import com.kodcu.javaday.dto.request.CreateCompTicketRequestDto;
import com.kodcu.javaday.mapper.CompanyMapper;
import com.kodcu.javaday.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Transactional
    public void saveCompanyDto(CreateCompTicketRequestDto companyDto){
        companyRepository.save(companyMapper.toCompanyFromCreateCompTicketRequestDto(companyDto));
    }

}
