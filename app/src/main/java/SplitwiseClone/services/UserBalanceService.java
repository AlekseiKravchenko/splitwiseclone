package SplitwiseClone.services;

import SplitwiseClone.entity.UserBalance;
import SplitwiseClone.repository.UserBalancesRepository;
import lombok.*;


@NoArgsConstructor
public class UserBalanceService {
    public UserBalance getUserBalance(Long userId) {
      return new UserBalance(userId);
    }
    public void createUserBalance(Long userId){
        UserBalance userBalance = new UserBalance(userId);
        UserBalancesRepository.userBalances.putIfAbsent(userId,userBalance);
    }

    public void deleteUserBalance(Long userId) {
        UserBalancesRepository.userBalances.remove(userId);
    }
}
