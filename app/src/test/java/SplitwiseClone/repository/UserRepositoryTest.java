package SplitwiseClone.repository;

import SplitwiseClone.entity.User;
import SplitwiseClone.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    UserService us = new UserService();
    User user1 = us.createUser("ololo","ololoev","asdasd@gmail.com","656565");
    @Test
    @DisplayName("Test create user and put him to repo")
    void userPutInRepo() {
        assertEquals(1,UserRepository.userMap.size());
    }
    @Test
    @DisplayName("Delete user from repo")
    void deleteUserFromRepo() {
        us.deleteUser(user1.getId());
        assertEquals(0,UserRepository.userMap.size());
    }
}