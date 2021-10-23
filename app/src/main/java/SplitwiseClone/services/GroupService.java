package SplitwiseClone.services;

import SplitwiseClone.entity.Group;
import SplitwiseClone.entity.User;
import SplitwiseClone.repository.GroupRepository;
import SplitwiseClone.repository.UserRepository;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class GroupService {
    GroupRepository gr = new GroupRepository();
    UserRepository ur = new UserRepository();

    public Group createGroup(String name) {
        Group group = new Group(name);
        gr.add(group);
        return group;
    }

    public void addListUsersToGroup(Long groupId, List<User> users) {
        if (gr.contains(groupId)) {
            gr.getById(groupId).getGroupMembers().addAll(users);
        }
    }

    public void addUserToGroup(Long groupId, Long userId) {
        if (gr.contains(groupId)) {
            gr.getById(groupId).getGroupMembers().add(ur.getById(userId));
        }
    }

    public void deleteUserFromGroup(Long groupId, Long userId) {
        if (gr.contains(groupId)) {
            gr.getById(groupId).getGroupMembers().remove(ur.getById(userId));
        } else {
            System.out.println("This  user does not exist");
        }
    }
}




