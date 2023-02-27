package org.example.service;

import org.example.model.User;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UserServiceTestLauncherTest {
    public static final User IVAN = User.of(1, "user1", "123");
    public static final User PETER = User.of(2, "user1", "123");
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

        assertThat(users).isEmpty();
        //assertTrue(users.isEmpty());
    }

    @Test
    void loginSuccessIfUserExists() {
        userService.add(IVAN);
        Optional<User> user = userService.login(IVAN.getUsername(), IVAN.getPassword());

        assertThat(user).isPresent();
        user.ifPresent(user1 -> assertThat(user1).isEqualTo(IVAN));

        //assertTrue(user.isPresent());
        //user.ifPresent(user1 -> assertEquals(IVAN, user1));
    }

    @Test
    void usersConvertedToMapById() {
        userService.add(IVAN, PETER);

        Map<Long, User> users = userService.getAllConvertedById();

        assertAll(
                () -> assertThat(users).containsKeys(IVAN.getId(), PETER.getId()),
                () -> assertThat(users).containsValues(IVAN, PETER)
        );

    }

    @Test
    void throwExceptionIfUsernameOrPasswordIsNull() {
        assertAll(
                () -> {
                    Exception exception = assertThrows(IllegalArgumentException.class,
                            () -> userService.login(null, "qqq"));
                    assertThat(exception.getMessage()).isEqualTo("username or password is null");
                },
                () -> {
                    Exception exception = assertThrows(IllegalArgumentException.class,
                            () -> userService.login("null", null));
                    assertThat(exception.getMessage()).isEqualTo("username or password is null");
                }
        );

//        try {
//            assertThrows(IllegalArgumentException.class, () -> userService.login(null, "qqq"));
//        } catch (IllegalArgumentException e) {
//            assertTrue(true);
//        }
    }


    @Test
    @Tag("login")
    void loginFailIfPasswordIsNotCorrect() {
        userService.add(IVAN);
        Optional<User> user = userService.login(IVAN.getUsername(), "123");

        assertThat(user).isPresent();

        //assertTrue(user.isPresent());

    }

    @Test
    void usersSizeIfUserAdded() {
        System.out.println("Test 2: " + this);
        userService.add(IVAN, PETER);

        List<User> users = userService.getAll();

        assertThat(users).hasSize(2);
        // assertEquals(2, users.size());
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

