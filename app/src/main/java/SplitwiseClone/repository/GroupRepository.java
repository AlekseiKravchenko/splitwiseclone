package SplitwiseClone.repository;

import SplitwiseClone.entity.*;
import java.util.*;

public class GroupRepository {
    public static Map<Long, Group>  groupMap = new HashMap<>();
    public static Map<Group, List<User>> groupMembers = new HashMap<>();
    public static Map<User, List<Group>> userGroups = new HashMap<>();
}
