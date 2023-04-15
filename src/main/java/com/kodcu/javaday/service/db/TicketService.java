package com.kodcu.javaday.service.db;

import com.kodcu.javaday.dto.request.CreateCompTicketRequestDto;
import com.kodcu.javaday.dto.request.CreateIndTicketRequestDto;
import com.kodcu.javaday.dto.request.CreateTicketRequestDto;
import com.kodcu.javaday.service.util.recaptcha.RecaptchaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketService {

    //captcha verify etmeyi unutma

    private final CompanyService companyService;
    private final IndividualService individualService;
    private final RecaptchaService recaptchaService;

    public void saveTicket(CreateTicketRequestDto ticketDto){
        if (!recaptchaService.isVerified())
            return;

        if (ticketDto instanceof CreateCompTicketRequestDto)
            companyService.saveCompanyDto((CreateCompTicketRequestDto) ticketDto);
        else if (ticketDto instanceof CreateIndTicketRequestDto)
            individualService.saveIndividualDto((CreateIndTicketRequestDto) ticketDto);
    }

}
