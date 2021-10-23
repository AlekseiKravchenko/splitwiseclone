package SplitwiseClone.services;

import SplitwiseClone.entity.User;
import SplitwiseClone.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserRepository ur = new UserRepository();
    UserService userService = new UserService();

    @BeforeEach
    void deleteData() {
        ur.deleteAll();
    }

    @Test
    @DisplayName("chek User create with service")
    void createUserWithService() {
        User user = userService.create
                ("Aleksei", "Kravchenko", "aswyga@gmail.com", "050 264 80 96");
        assertEquals(1, ur.getAll().size());
    }

    @Test
    @DisplayName("chek User delete with service")
    void deleteUserWithService() {
        User user = userService.create
                ("Aleksei", "Kravchenko", "aswyga@gmail.com", "050 264 80 96");
        userService.delete(user.getId());
        assertEquals(0, ur.getAll().size());
    }

    @Test
    @DisplayName("check getting user by ID from repo")
    void getUserById() {
        User user = userService.create
                ("Aleksei", "Kravchenko", "aswyga@gmail.com", "050 264 80 96");
        assertEquals(user, userService.getFromRepository(user.getId()));
    }
}