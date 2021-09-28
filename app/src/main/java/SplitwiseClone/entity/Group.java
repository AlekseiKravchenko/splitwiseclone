package SplitwiseClone.entity;


import lombok.*;

@Getter
@Setter
@ToString
public class Group {

    private Long id ;
    private String name;
    private static Long count = 1L;

    public Group(String name) {
        this.name = name;
        this.id = count;
        count++;
    }
}