package sg.il.res.net.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sg.il.res.service.TestService;

@RestController
public class TestApi {
    @Autowired
    private TestService testService;

    @GetMapping("/testEndpoint")
    public ResponseEntity<Void> testEndpoint() {
        testService.test();
        return ResponseEntity.ok().build();
    }
}
