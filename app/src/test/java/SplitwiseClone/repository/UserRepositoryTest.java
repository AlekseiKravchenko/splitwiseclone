package SplitwiseClone.repository;

import SplitwiseClone.entity.User;
import SplitwiseClone.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserService userService;
    UserRepository userRepository;

    @BeforeEach
    void deleteData() {
        userService = new UserService();
        userRepository = new UserRepository();
    }

    @Test
    @DisplayName("Test create user and put him to repo")
    void userPutInRepo() {
        User user1 = userService.create("ololo", "ololoev", "asdasd@gmail.com", "656565");
        assertTrue(userRepository.contains(user1.getId()));
    }

    @Test
    @DisplayName("Delete user from repo")
    void deleteUserFromRepo() {
        User user1 = userService.create("ololo", "ololoev", "asdasd@gmail.com", "656565");
        userRepository.delete(user1.getId());
        assertFalse(userRepository.getAll().contains(user1));
    }
}