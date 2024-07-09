package sg.il.uaa.net.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sg.il.uaa.data.dto.UserSignInDto;
import sg.il.uaa.service.UserAuthService;

@RestController
public class MainApi {
    @Autowired
    private UserAuthService userAuthService;

    @GetMapping("/auth")
    public ResponseEntity<String> auth(@RequestBody UserSignInDto userSignInDto) {
        String token = userAuthService.auth(userSignInDto);
        return ResponseEntity.ok(token);
    }
}
