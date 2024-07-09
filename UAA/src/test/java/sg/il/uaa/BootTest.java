package sg.il.uaa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import sg.il.uaa.data.entity.User;
import sg.il.uaa.data.jpa.UserRepo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Boot.class)
public class BootTest {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testBoot() {
        assertNotNull(applicationContext, "Fail load context");
    }

    @Test
    public void testDB() {
        List<User> actual = userRepo.findAll();

        List<User> expected = new ArrayList<>();
        expected.add(new User(1L, "login_1", "123"));
        expected.add(new User(2L, "login_2", "123"));
        expected.add(new User(3L, "login_3", "123"));

        assertIterableEquals(expected, actual, "The list of users should be equal");

    }
}