package SplitwiseClone.repository;

import SplitwiseClone.entity.Group;
import SplitwiseClone.utils.IdGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository implements CrudRepository<Group> {
    private static final Map<Long, Group> groupMap = new HashMap<>();

    @Override
    public void add(Group object) {
        object.setId(IdGenerator.generateDebtId());
        groupMap.putIfAbsent(object.getId(), object);
    }

    @Override
    public void delete(Long id) {
        groupMap.remove(id);
    }

    @Override
    public Group getById(Long id) {
        return groupMap.get(id);
    }

    @Override
    public boolean contains(Long id) {
        return groupMap.containsKey(id);
    }

    @Override
    public void deleteAll() {
        groupMap.clear();
    }

    @Override
    public List<Group> getAll() {
        return new ArrayList<>(groupMap.values());
    }
}
