package sg.il.res.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sg.il.res.data.dto.uaa.UserSignInDto;

@Service
public class TestService {
    @Autowired
    private RestTemplate template;
    @Autowired
    private UAAEndpoints uaaEndpoints;

    public String test() {
        UserSignInDto userSignInDto = new UserSignInDto("login_1", "p1");
        ResponseEntity<String> response = template.postForEntity(uaaEndpoints.getAuthUrl(), userSignInDto, String.class);
        return response.getBody();
    }
}
