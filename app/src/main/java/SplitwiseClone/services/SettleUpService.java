package SplitwiseClone.services;

import SplitwiseClone.entity.SettleUp;
import SplitwiseClone.repository.SettleUpRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class SettleUpService {
    final SettleUpRepository settleUpRepository;

    public SettleUp createSettleUp(Long ownerId, Long userId, BigDecimal amount) {
        SettleUp settleUp = new SettleUp(amount, ownerId, userId);
        settleUpRepository.add(settleUp);
        return settleUp;
    }

}
