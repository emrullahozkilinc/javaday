package com.kodcu.javaday.service.util.recaptcha;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class IRecaptchaService implements RecaptchaService {

    @Value("${google.recaptcha.key.secret}")
    private String secret;

    private static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");
    private boolean isVerified;

    @Override
    public boolean processResponse(String captchaResponse, String ip) {
        if (!responseSanityCheck(captchaResponse)) {
            return false;
        }

        String captchaURL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";
        URI verifyUri = URI.create(String.format(captchaURL, secret, captchaResponse, ip));


        Optional<GoogleResponse> googleResponse = Optional.ofNullable(new RestTemplate().getForObject(verifyUri, GoogleResponse.class));

        isVerified = googleResponse.orElse(new GoogleResponse()).isSuccess();

        return isVerified;
    }

    private boolean responseSanityCheck(String response){
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    @Override
    public boolean isVerified() {
        return isVerified;
    }
}
