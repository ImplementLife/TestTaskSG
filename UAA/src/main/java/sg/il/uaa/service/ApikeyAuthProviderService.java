package sg.il.uaa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sg.il.uaa.data.dto.apikeyauthprovider.UserAuthDto;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class ApikeyAuthProviderService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${sg.il.uaa.url.apikey-auth-provider}")
    private String apikeyAuthProviderUrl;
    private String authCreateUrl;
    private String authValidateUrl;

    @PostConstruct
    private void postConstruct() {
        authCreateUrl = apikeyAuthProviderUrl + "/auth/create";
        authValidateUrl = apikeyAuthProviderUrl + "/auth/validate";
    }

    public String createToken(UserAuthDto userAuthDto) {
        log.debug("createToken");
        ResponseEntity<String> response = restTemplate.postForEntity(authCreateUrl, userAuthDto, String.class);
        String token = response.getBody();
        return token;
    }

    public boolean validToken(String token) {
        log.debug("validToken");
        ResponseEntity<Boolean> response = restTemplate.postForEntity(authValidateUrl, token, Boolean.class);
        Boolean isTokenValid = response.getBody();
        return isTokenValid;
    }
}
