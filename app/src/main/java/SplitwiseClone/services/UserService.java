package SplitwiseClone.services;

import SplitwiseClone.entity.User;
import SplitwiseClone.repository.UserRepository;
import SplitwiseClone.utils.IdGenerator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository = new UserRepository();
    private final UserBalanceService userBalanceService = new UserBalanceService();

    public User create(String firstName, String lastName, String email, String phone ) {
        User user = new User(firstName,lastName,email,phone, IdGenerator.generateUserId());
        userRepository.add(user.getId(),user);
//        userBalanceService.createUserBalance(user.getId());
        return user;
    }

    public void delete(Long userId) {
        userRepository.delete(userId);
    }

    public User getFromRepository(Long userId) {
       return userRepository.getById(userId);
    }
}
