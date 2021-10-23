package SplitwiseClone.repository;

import SplitwiseClone.entity.Debt;
import SplitwiseClone.utils.IdGenerator;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class DebtsRepository implements CrudRepository<Debt> {
    private static final Map<Long, Debt> debtsMap = new HashMap<>();

    @Override
    public void add(Debt object) {
        object.setId(IdGenerator.generateDebtId());
        debtsMap.put(object.getId(),object);
    }

    @Override
    public void delete(Long id) {
        debtsMap.remove(id);
    }

    @Override
    public Debt getById(Long id) {
        return debtsMap.get(id);
    }

    @Override
    public boolean contains(Long id) {
        return debtsMap.containsKey(id);
    }

    @Override
    public void deleteAll() {
        debtsMap.clear();
    }

    @Override
    public List<Debt> getAll() {
        return new ArrayList<>(debtsMap.values());
    }
}
