package sg.il.auth.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sg.il.auth.data.dto.UserAuthDto;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.*;

import static java.lang.Long.valueOf;

@Slf4j
@Service
public class JwtAuthService {
    private String secretKey;
    private Algorithm algorithm;
    private JWTVerifier verifier;
    private long lifetime;

    @PostConstruct
    protected void init() {
        secretKey = UUID.randomUUID().toString(); //TODO: get from env var
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        algorithm = Algorithm.HMAC256(secretKey);
        verifier = JWT.require(algorithm).build();
        lifetime = Duration.ofHours(1).toMillis();
    }

    public String createToken(UserAuthDto userAuthDto) {
        JWTCreator.Builder builder = createToken(userAuthDto, lifetime);
        String token = builder
            .withClaim("id", userAuthDto.getId())
            .withClaim("login", userAuthDto.getLogin())
            .sign(algorithm);
        return token;
    }

    private JWTCreator.Builder createToken(UserAuthDto userAuthDto, long lifetime) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + lifetime);

        JWTCreator.Builder builder = JWT.create()
            .withIssuedAt(now)
            .withExpiresAt(validity)
            .withSubject(userAuthDto.getId().toString());
        return builder;
    }

    public boolean validateAccessToken(String token) {
        try {
            verifier.verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
