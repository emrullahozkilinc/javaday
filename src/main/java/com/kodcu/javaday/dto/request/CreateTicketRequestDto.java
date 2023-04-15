package com.kodcu.javaday.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.kodcu.javaday.model.Participant;
import com.kodcu.javaday.model.Person;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@JsonTypeInfo(
        use=JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateCompTicketRequestDto.class, name = "company"),
        @JsonSubTypes.Type(value = CreateIndTicketRequestDto.class, name = "individual")
})
@Data
@NoArgsConstructor
public class CreateTicketRequestDto {

    @Valid
    protected Person person;
    @Valid
    protected Set<Participant> participants;

    protected String captchaResponse;
}
