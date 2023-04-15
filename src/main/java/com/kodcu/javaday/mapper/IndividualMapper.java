package com.kodcu.javaday.mapper;

import com.kodcu.javaday.dto.request.CreateIndTicketRequestDto;
import com.kodcu.javaday.model.Individual;
import org.mapstruct.Mapper;

@Mapper(implementationName = "IndividualMapperImpl" , componentModel = "spring")
public interface IndividualMapper {
    Individual toIndividualFromCreateIndRequestDto(CreateIndTicketRequestDto createIndTicketRequestDto);
}
