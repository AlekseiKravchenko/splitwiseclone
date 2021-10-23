package SplitwiseClone.repository;

import SplitwiseClone.entity.SettleUp;
import SplitwiseClone.utils.IdGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettleUpRepository implements CrudRepository<SettleUp> {
    private static final Map<Long, SettleUp> settleUpMap = new HashMap<>();

    @Override
    public void add(SettleUp object) {
        object.setId(IdGenerator.generateDebtId());
        settleUpMap.put(object.getId(), object);
    }

    @Override
    public void delete(Long settleUpId) {
        settleUpMap.remove(settleUpId);
    }

    @Override
    public SettleUp getById(Long settleUpId) {
        return settleUpMap.get(settleUpId);
    }

    @Override
    public boolean contains(Long settleUpId) {
        return settleUpMap.containsKey(settleUpId);
    }

    @Override
    public void deleteAll() {
        settleUpMap.clear();
    }

    @Override
    public List<SettleUp> getAll() {
        return null;
    }
}
