package SplitwiseClone.services;

import SplitwiseClone.entity.*;
import SplitwiseClone.repository.*;
import SplitwiseClone.utils.IdGenerator;
import lombok.*;

import java.util.*;

@NoArgsConstructor
public class GroupService {
    public Group createGroup(String name) {
        Group group = new Group(name, IdGenerator.generateGroupId());
        GroupRepository.groupMap.put(group.getId(),group);
        return group;
    }
    public void addListUsersToGroup(Long groupId, List<User> users) {
        if(GroupRepository.groupMap.containsKey(groupId)) {
            GroupRepository.groupMap.get(groupId).getGroupMembers().addAll(users);
        }
    }
    public void addUserToGroup(Long groupId, Long userId) {
        if(GroupRepository.groupMap.containsKey(groupId)) {
            GroupRepository.groupMap.get(groupId).getGroupMembers().add(UserRepository.userMap.get(userId));
        }
    }
    public void deleteUserFromGroup(Long groupId, Long userId) {
        if (GroupRepository.groupMap.containsKey(groupId)) {
            GroupRepository.groupMap.get(groupId).getGroupMembers().remove(UserRepository.userMap.get(userId));
        } else {
            System.out.println("This  user does not exist");
        }
    }
}




