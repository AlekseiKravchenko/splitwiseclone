package SplitwiseClone;

import java.util.*;


public class UserGroup {
    private String groupName;
    private Map<String,ArrayList<User>> group;

   //public UserGroup(String groupName, Map<String, ArrayList<User>> group,ArrayList users) {
   //    this.groupName = groupName;
   //    this.group = group;
   //}

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Map<String, ArrayList<User>> getGroup() {
        return group;
    }

    public void setGroup(Map<String, ArrayList<User>> group) {
        this.group = group;
    }
}
