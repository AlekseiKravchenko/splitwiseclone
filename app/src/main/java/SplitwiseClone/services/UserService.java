package SplitwiseClone.services;

import SplitwiseClone.entity.*;
import SplitwiseClone.repository.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class UserService {
    public User createUser (String firstName, String lastName, String email, String phone ) {
        User user = new User(firstName,lastName,email,phone);
        UserRepository.userMap.putIfAbsent(email, user);
        return user;
    }
    public void deleteUser(String email) {
        UserRepository.userMap.remove(email);
    }
    public Map<User, List<Group>> collectUserGroups (User user) {
        List<Group> userGroupValues = new ArrayList<>();
        for (Map.Entry<Group, List<User>> entry : GroupRepository.groupMembers.entrySet()) {
            if (entry.getValue().contains(user)) {
                userGroupValues.add(entry.getKey());
            }
        }
        GroupRepository.userGroups.put(user, userGroupValues);
        return  GroupRepository.userGroups;
    }
}
