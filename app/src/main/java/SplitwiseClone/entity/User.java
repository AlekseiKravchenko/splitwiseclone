package SplitwiseClone.entity;

import lombok.*;

@ToString
@Getter
@Setter
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public User(String firstName, String lastName, String email, String phone,Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.id = id;
    }
}