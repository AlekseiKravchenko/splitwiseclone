package SplitwiseClone.repository;

import SplitwiseClone.entity.User;
import SplitwiseClone.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserService us;
    UserRepository ur;
    @BeforeEach
    void deleteData() {
        us = new UserService();
        ur = new UserRepository();
    }

    @Test
    @DisplayName("Test create user and put him to repo")
    void userPutInRepo() {
        User user1 = us.create("ololo","ololoev","asdasd@gmail.com","656565");
        assertTrue(ur.contains(user1.getId()));
    }
    @Test
    @DisplayName("Delete user from repo")
    void deleteUserFromRepo() {
        User user1 = us.create("ololo","ololoev","asdasd@gmail.com","656565");
        ur.delete(user1.getId());
        assertFalse(ur.getAll().contains(user1));
    }
}