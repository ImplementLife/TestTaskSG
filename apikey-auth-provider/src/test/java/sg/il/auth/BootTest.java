package sg.il.auth;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Boot.class)
public class BootTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testBoot() {
        assertNotNull(applicationContext, "Fail load context");
    }
}