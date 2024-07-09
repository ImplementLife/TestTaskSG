package sg.il.auth.net.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.il.auth.data.dto.UserAuthDto;
import sg.il.auth.service.JwtAuthService;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthApi {
    @Autowired
    private JwtAuthService authService;

    @PostMapping("/create")
    public String auth(@RequestBody UserAuthDto userAuthDto) {
        log.debug("/auth/create");
        return authService.createToken(userAuthDto);
    }

    @PostMapping("/validate")
    public boolean validate(@RequestBody String token) {
        return authService.validateAccessToken(token);
    }
}
