package com.kodcu.javaday.service.util.recaptcha;

public interface RecaptchaService {
    boolean processResponse(String captchaResponse, String ip);
    boolean isVerified();
}
