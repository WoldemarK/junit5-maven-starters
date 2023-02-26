import org.example.model.User;
import org.example.service.UserService;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UserServiceTest {
    private UserService userService;

    @BeforeAll
    static void init() {
        System.out.println("BeforeAll: ");
    }

    @BeforeEach
    void prepare() {
        System.out.println("BeforeEach: " + this);
        userService = new UserService();
    }

    @Test
    void usersEmptyIfNoUserAdded() {
        System.out.println("Test 1: " + this);
        List<User> users = userService.getAll();
        assertTrue(users.isEmpty());
    }

    @Test
    void usersSizeIfUserAdded() {
        System.out.println("Test 2: " + this);
        userService.add(new User());
        userService.add(new User());

        List<User> users = userService.getAll();
        assertEquals(2, users.size());
    }

    @AfterEach
    void deleteDateFromDatabase() {
        System.out.println("AfterEach: " + this);
    }

    @AfterAll
    static void close() {
        System.out.println("After All: ");
    }
}

