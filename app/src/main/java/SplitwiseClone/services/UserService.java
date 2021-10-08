package SplitwiseClone.services;

import SplitwiseClone.utils.IdGenerator;
import SplitwiseClone.repository.*;
import lombok.NoArgsConstructor;
import SplitwiseClone.entity.*;

@NoArgsConstructor
public class UserService {
    UserRepository us = new UserRepository();
    UserBalanceService userBalanceService = new UserBalanceService();
    public User createUser(String firstName, String lastName, String email, String phone ) {
        User user = new User(firstName,lastName,email,phone, IdGenerator.generateUserId());
        us.add(user.getId(),user);
        userBalanceService.createUserBalance(user.getId());
        return user;
    }
    public void deleteUser(Long userId) {
        us.delete(userId);
    }
    public User getUserFromRepository(Long userId) {
       return us.getById(userId);
    }
}
