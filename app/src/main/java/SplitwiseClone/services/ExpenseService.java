package SplitwiseClone.services;

import SplitwiseClone.repository.TransactionRepository;
import SplitwiseClone.repository.GroupRepository;
import SplitwiseClone.repository.UserRepository;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExpenseService {
    TransactionRepository transactionRepository = new TransactionRepository();
    UserRepository userRepository = new UserRepository();
    GroupRepository groupRepository = new GroupRepository();
}
