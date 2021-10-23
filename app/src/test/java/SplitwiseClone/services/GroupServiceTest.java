package SplitwiseClone.services;

import SplitwiseClone.entity.Group;
import SplitwiseClone.entity.User;
import SplitwiseClone.repository.GroupRepository;
import SplitwiseClone.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupServiceTest {
    GroupRepository groupRepository = new GroupRepository();
    UserRepository userRepository = new UserRepository();
    UserService userService = new UserService();
    GroupService groupService = new GroupService();

    @BeforeEach
    void deleteData() {
        groupRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("Check create group by Group service")
    void createGroup() {
        groupService.createGroup("Co-workers");
        assertEquals(1, groupRepository.getAll().size());
    }

    @Test
    @DisplayName("Check adding List users to group")
    void addListUsersToGroup() {
        Group group = groupService.createGroup("Co-workers");
        List<User> users = new ArrayList<>();
        User user1 = userService.create(
                "Aleksei",
                "Kravchenko",
                "aswyga@gmail.com",
                "0502648096");

        User user2 = userService.create(
                "Aleksei",
                "Kravchenko",
                "aswyga@gmail.com",
                "0502648096");

        users.add(user1);
        users.add(user2);

        groupService.addListUsersToGroup(group.getId(), users);
        assertEquals(2, groupRepository.getById(group.getId()).getGroupMembers().size());
    }

    @Test
    @DisplayName("Check adding user to group")
    void addUserToGroup() {
        Group group = groupService.createGroup("Co-workers");
        User user = new User("Aleksei", "Kravchenko",
                "aswyga@gmail.com", "0502648096");
        groupService.addUserToGroup(group.getId(), user.getId());
        assertEquals(1, groupRepository.getById(group.getId()).getGroupMembers().size());
    }

    @Test
    @DisplayName("Delete user from group")
    void deleteUserFromGroup() {
        Group group = groupService.createGroup("Co-workers");
        User user = userService.create(
                "Aleksei",
                "Kravchenko",
                "aswyga@gmail.com",
                "0502648096");

        groupService.addUserToGroup(group.getId(), user.getId());
        groupService.deleteUserFromGroup(group.getId(), user.getId());

        assertEquals(0, groupRepository.getById(group.getId()).getGroupMembers().size());
    }
}