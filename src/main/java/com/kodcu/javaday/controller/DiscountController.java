package com.kodcu.javaday.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discount")
@CrossOrigin
@RequiredArgsConstructor
public class DiscountController {

    @GetMapping
    public ResponseEntity<Boolean> checkCaptcha(@RequestParam String discountCode, HttpServletRequest request){
        boolean result = recaptchaService.processResponse(captchaResponse,request.getRemoteAddr());
        if (result)
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
}
