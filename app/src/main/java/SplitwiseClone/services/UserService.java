package SplitwiseClone.services;

import SplitwiseClone.utils.IdGenerator;
import SplitwiseClone.repository.*;
import lombok.NoArgsConstructor;
import SplitwiseClone.entity.*;

@NoArgsConstructor
public class UserService {
    UserBalanceService userBalanceService = new UserBalanceService();
    public User createUser(String firstName, String lastName, String email, String phone ) {
        User user = new User(firstName,lastName,email,phone, IdGenerator.generateUserId());
        UserRepository.userMap.putIfAbsent(user.getId(), user);
        userBalanceService.createUserBalance(user.getId());
        return user;
    }
    public void deleteUser(Long userId) {
        UserRepository.userMap.remove(userId);
        userBalanceService.deleteUserBalance(userId);
    }
    public User getUserFromRepository(Long userId) {
        return UserRepository.userMap.get(userId);
    }
}
