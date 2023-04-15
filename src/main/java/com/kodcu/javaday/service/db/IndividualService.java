package com.kodcu.javaday.service.db;

import com.kodcu.javaday.dto.request.CreateIndTicketRequestDto;
import com.kodcu.javaday.mapper.IndividualMapper;
import com.kodcu.javaday.repository.IndividualRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IndividualService {

    private final IndividualRepository individualRepository;
    private final IndividualMapper individualMapper;

    @Transactional
    public void saveIndividualDto(CreateIndTicketRequestDto individualDto){
        individualRepository.save(individualMapper.toIndividualFromCreateIndRequestDto(individualDto));
    }
}
