package SplitwiseClone.services;

import SplitwiseClone.entity.*;
import SplitwiseClone.repository.*;
import SplitwiseClone.utils.IdGenerator;
import lombok.*;

import java.util.*;

@NoArgsConstructor
public class GroupService {
    GroupRepository gr = new GroupRepository();
    UserRepository ur = new UserRepository();
    public Group createGroup(String name) {
        Group group = new Group(name, IdGenerator.generateGroupId());
        gr.add(group.getId(),group);
        return group;
    }
    public void addListUsersToGroup(Long groupId, List<User> users) {
        if(gr.contains(groupId)) {
            gr.getById(groupId).getGroupMembers().addAll(users);
        }
    }
    public void addUserToGroup(Long groupId, Long userId) {
        if(gr.contains(groupId)) {
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




