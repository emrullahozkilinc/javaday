package com.kodcu.javaday.controller;

import com.kodcu.javaday.service.util.recaptcha.RecaptchaService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/recaptcha")
@RequiredArgsConstructor
public class RecaptchaController {

    private final RecaptchaService recaptchaService;

    @GetMapping
    public ResponseEntity<Boolean> checkCaptcha(@RequestParam String captchaResponse, HttpServletRequest request){
        boolean result = recaptchaService.processResponse(captchaResponse,request.getRemoteAddr());
        if (result)
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
}
