package sg.il.uaa.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sg.il.uaa.data.dto.UserSignInDto;
import sg.il.uaa.data.dto.apikeyauthprovider.UserAuthDto;
import sg.il.uaa.data.entity.User;
import sg.il.uaa.data.jpa.UserRepo;

import java.util.Optional;

@Slf4j
@Service
public class UserAuthService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ApikeyAuthProviderService apikeyAuthProviderService;

    private User performAuth(UserSignInDto userSignInDto) {
        Optional<User> byLogin = userRepo.findByLogin(userSignInDto.getLogin());
        User user = byLogin.orElseThrow(() -> new IllegalArgumentException("Wrong user login."));
        if (!user.getPass().equals(userSignInDto.getPass())) throw new IllegalArgumentException("Wrong user pass.");
        return user;
    }

    public String auth(UserSignInDto userSignInDto) {
        log.info("auth");
        User user = performAuth(userSignInDto);

        UserAuthDto userAuthDto = new UserAuthDto();
        userAuthDto.setLogin(user.getLogin());
        userAuthDto.setId(user.getId());

        String token = apikeyAuthProviderService.createToken(userAuthDto);
        return token;
    }
}
