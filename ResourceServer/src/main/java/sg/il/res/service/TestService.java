package sg.il.res.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sg.il.res.data.dto.uaa.UserSignInDto;

@Slf4j
@Service
public class TestService {
    @Autowired
    private RestTemplate template;
    @Autowired
    private UAAEndpoints uaaEndpoints;

    public String test() {
        log.debug("test");
        UserSignInDto userSignInDto = new UserSignInDto("login_1", "p1");
        ResponseEntity<String> response = template.postForEntity(uaaEndpoints.getAuthUrl(), userSignInDto, String.class);
        return response.getBody();
    }
}
