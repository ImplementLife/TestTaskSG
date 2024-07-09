package sg.il.uaa.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import sg.il.uaa.data.dto.UserSignInDto;
import sg.il.uaa.data.entity.User;
import sg.il.uaa.data.jpa.UserRepo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
@SpringBootTest
public class UserAuthServiceTest {

    @Mock
    private UserRepo userRepo;

    @Mock
    private ApikeyAuthProviderService apikeyAuthProviderService;

    @InjectMocks
    private UserAuthService userAuthService;

    @Test
    public void testAuth() {
        UserSignInDto userSignInDto = new UserSignInDto("testUser", "123");

        User user = new User();
        user.setId(1L);
        user.setLogin("testUser");
        user.setPass("123");

        when(userRepo.findByLogin("testUser")).thenReturn(Optional.of(user));
        when(apikeyAuthProviderService.createToken(any())).thenReturn("mockedToken");


        String token = userAuthService.auth(userSignInDto);


        assertEquals("mockedToken", token);
        verify(userRepo, times(1)).findByLogin("testUser");
        verify(apikeyAuthProviderService, times(1)).createToken(any());
    }
}