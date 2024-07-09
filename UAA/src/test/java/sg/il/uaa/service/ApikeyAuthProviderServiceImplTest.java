//package sg.il.uaa.service;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import sg.il.uaa.data.dto.apikeyauthprovider.UserAuthDto;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith({ MockitoExtension.class })
//@SpringBootTest
//public class ApikeyAuthProviderServiceImplTest {
//    @Mock
//    private RestTemplate restTemplate;
//
//    @InjectMocks
//    private ApikeyAuthProviderServiceImpl apikeyAuthProviderService;
//
//
//    @Test
//    public void testCreateToken() {
//        UserAuthDto userAuthDto = new UserAuthDto();
//        String expectedToken = "sampleToken";
//
//        ResponseEntity<String> responseEntity = new ResponseEntity<>(expectedToken, HttpStatus.OK);
//        when(restTemplate.postForEntity(anyString(), any(), eq(String.class)))
//            .thenReturn(responseEntity);
//
//        String actualToken = apikeyAuthProviderService.createToken(userAuthDto);
//
//        assertEquals(expectedToken, actualToken);
//    }
//
//    @Test
//    public void testValidToken() {
//        String token = "sampleToken";
//
//        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(true, HttpStatus.OK);
//        when(restTemplate.postForEntity(anyString(), any(), eq(Boolean.class)))
//            .thenReturn(responseEntity);
//
//        boolean isValid = apikeyAuthProviderService.validToken(token);
//
//        assertTrue(isValid);
//    }
//}
