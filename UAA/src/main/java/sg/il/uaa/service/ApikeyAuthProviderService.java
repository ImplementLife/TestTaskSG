package sg.il.uaa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sg.il.uaa.data.dto.apikeyauthprovider.UserAuthDto;

@Slf4j
@Service
public class ApikeyAuthProviderService {

    @Value("${sg.il.uaa.url.apikey-auth-provider}")
    private String apikeyAuthProviderUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String createToken(UserAuthDto userAuthDto) {
        ResponseEntity<String> response = restTemplate.postForEntity(apikeyAuthProviderUrl + "/auth/create", userAuthDto, String.class);
        String token = response.getBody();
        return token;
    }

    public boolean validToken(String token) {
        ResponseEntity<Boolean> response = restTemplate.postForEntity(apikeyAuthProviderUrl + "/auth/validate", token, Boolean.class);
        Boolean isTokenValid = response.getBody();
        return isTokenValid;
    }
}
