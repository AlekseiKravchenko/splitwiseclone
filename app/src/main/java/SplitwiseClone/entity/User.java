package SplitwiseClone.entity;


import lombok.*;

@ToString
@Getter
@Setter
public class User {
    private static Long count = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public User(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.id = count;
        count++;
    }
}