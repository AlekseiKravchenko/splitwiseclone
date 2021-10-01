package SplitwiseClone.services;

import SplitwiseClone.utils.IdGenerator;
import SplitwiseClone.repository.*;
import lombok.NoArgsConstructor;
import SplitwiseClone.entity.*;

import java.util.Map;


@NoArgsConstructor
public class UserService {
    public User createUser (String firstName, String lastName, String email, String phone ) {
        User user = new User(firstName,lastName,email,phone, IdGenerator.generateUserId());
        UserRepository.userMap.putIfAbsent(user.getId(), user);
        return user;
    }
    public void deleteUser(Long userId) {
        UserRepository.userMap.remove(userId);
    }

}
