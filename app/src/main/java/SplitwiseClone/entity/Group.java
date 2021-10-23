package SplitwiseClone.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Group {

    private Long id;
    private String name;
    private List<User> groupMembers;


    public Group(String name) {
        this.name = name;
        this.groupMembers = new ArrayList<>();
    }
}