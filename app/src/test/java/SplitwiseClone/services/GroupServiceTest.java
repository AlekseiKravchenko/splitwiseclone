package SplitwiseClone.services;

import SplitwiseClone.entity.Group;
import SplitwiseClone.entity.User;
import SplitwiseClone.repository.GroupRepository;
import SplitwiseClone.repository.UserRepository;
import SplitwiseClone.utils.IdGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class GroupServiceTest {
    GroupService gp = new GroupService();
    @BeforeEach
    void deleteData(){
        GroupRepository.groupMap.clear();
        UserRepository.userMap.clear();
        IdGenerator.expenseIdCount = 0L;
        IdGenerator.groupIdCount = 0L;
        IdGenerator.userIdCount = 0L;
    }

    @Test
    @DisplayName("Check create group by Group service")
    void createGroup(){
        gp.createGroup("Co-workers");
        assertEquals(1,GroupRepository.groupMap.size());
    }
    @Test
    @DisplayName("Check adding List users to group")
    void addListUsersToGroup(){
        Group group =  gp.createGroup("Co-workers");
        List<User> users = new ArrayList<User>(
                Arrays.asList(new User("Aleksei","Kravchenko",
                        "aswyga@gmail.com","0502648096", IdGenerator.generateUserId()),
                new User("fdsfds","asdasd","dasdas","asdasd",IdGenerator.generateUserId()))
        );
        gp.addListUsersToGroup(group.getId(), users);
        assertEquals(2,GroupRepository.groupMap.get(group.getId()).getGroupMembers().size());
    }

    @Test
    @DisplayName("Check adding user to group")
    void addUserToGroup(){
        Group group =  gp.createGroup("Co-workers");
        User user = new User("Aleksei","Kravchenko",
                "aswyga@gmail.com","0502648096", IdGenerator.generateUserId());
        gp.addUserToGroup(group.getId(), user.getId());
        assertEquals(1,GroupRepository.groupMap.get(group.getId()).getGroupMembers().size());
    }
    @Test
    @DisplayName("Delete user from group")
    void deleteUserFromGroup(){
        Group group =  gp.createGroup("Co-workers");
        User user = new User("Aleksei","Kravchenko",
                "aswyga@gmail.com","0502648096", IdGenerator.generateUserId());
        gp.addUserToGroup(group.getId(), user.getId());
        gp.deleteUserFromGroup(group.getId(), user.getId());
        assertEquals(0,GroupRepository.groupMap.get(group.getId()).getGroupMembers().size());
    }
}