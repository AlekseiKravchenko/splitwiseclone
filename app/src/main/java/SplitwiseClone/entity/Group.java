package SplitwiseClone.entity;

import lombok.*;

import java.util.*;

@Getter
@Setter
@ToString
public class Group {

    private Long id ;
    private String name;
    private List<User> groupMembers;


    public Group(String name,Long id) {
        this.groupMembers = new ArrayList<>();
        this.name = name;
        this.id = id;
    }

    public void deleteUserFromGroup(Long userId){
        this.groupMembers.remove(userId);
    }
}