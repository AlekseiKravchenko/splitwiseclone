package SplitwiseClone.services;

import SplitwiseClone.entity.UserBalance;
import SplitwiseClone.repository.UserBalancesRepository;
import lombok.*;


@NoArgsConstructor
public class UserBalanceService {
    UserBalancesRepository ubr = new UserBalancesRepository();
    public UserBalance getUserBalance(Long userId) {
      return new UserBalance(userId);
    }
    public void createUserBalance(Long userId){
        UserBalance userBalance = new UserBalance(userId);
        ubr.add(userBalance.getUserBalanceId(),userBalance);
    }

    public void deleteUserBalance(Long userId) {
        ubr.delete(userId);
    }
}
