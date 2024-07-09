package sg.il.res.net.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    @GetMapping("/testEndpoint")
    public ResponseEntity<Void> testEndpoint() {
        return ResponseEntity.ok().build();
    }
}
