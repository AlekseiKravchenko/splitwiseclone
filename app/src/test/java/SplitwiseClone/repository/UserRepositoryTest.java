package SplitwiseClone.repository;

import SplitwiseClone.entity.User;
import SplitwiseClone.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UserRepositoryTest {
    UserService us = new UserService();
    UserRepository ur = new UserRepository();
    @AfterEach
    void deleteData() {
        ur.deleteAll();
    }

    @Test
    @DisplayName("Test create user and put him to repo")
    void userPutInRepo() {
        User user1 = us.createUser("ololo","ololoev","asdasd@gmail.com","656565");
        assertEquals(1,ur.getAll().size());
    }
    @Test
    @DisplayName("Delete user from repo")
    void deleteUserFromRepo() {
        User user1 = us.createUser("ololo","ololoev","asdasd@gmail.com","656565");
        ur.delete(user1.getId());
        assertEquals(0,ur.getAll().size());
    }
}