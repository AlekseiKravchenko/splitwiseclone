package SplitwiseClone.entity;

import SplitwiseClone.entity.Expense.Expense;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Group {

    private Long id ;
    private String name;
    private List<User> groupMembers;
    private List<Expense> groupExpenses;


    public Group(String name,Long id) {
        this.groupMembers = new ArrayList<>();
        this.groupExpenses = new ArrayList<>();
        this.name = name;
        this.id = id;
    }
}