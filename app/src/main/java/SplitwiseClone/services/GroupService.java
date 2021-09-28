package SplitwiseClone.services;

import SplitwiseClone.entity.*;
import SplitwiseClone.repository.GroupRepository;
import lombok.*;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

@NoArgsConstructor
public class GroupService {
    public Group createGroup(String name) {
        Group group = new Group(name);
        GroupRepository.groupMap.putIfAbsent(group.getId(), group);
        return group;
    }
    public void addListUsersToGroup(Group group, List<User> users) {
        GroupRepository.groupMembers.put(group, users);
    }
    public void addUserToGroup(Group group, User user) {
        if (GroupRepository.groupMembers.containsKey(group)) {
            GroupRepository.groupMembers.get(group).add(user);
        } else {
            List<User> userAsList = new ArrayList<>();
            userAsList.add(user);
            GroupRepository.groupMembers.put(group,userAsList);
        }
    }
    public void deleteUserFromGroup(Group group, User user) {
        if (GroupRepository.groupMembers.get(group).contains(user)) {
            GroupRepository.groupMembers.get(group).remove(user);
        } else {
            System.out.println("This  user does not exist");
        }
    }
}




