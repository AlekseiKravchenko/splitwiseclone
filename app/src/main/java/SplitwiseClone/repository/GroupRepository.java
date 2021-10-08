package SplitwiseClone.repository;

import SplitwiseClone.entity.*;
import java.util.*;

public class GroupRepository implements CrudRepository<Group>{
    private static final Map<Long, Group>  groupMap = new HashMap<>();

    @Override
    public void add(Long id, Group object) {
        groupMap.putIfAbsent(id,object);
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
