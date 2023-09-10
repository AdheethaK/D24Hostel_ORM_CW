package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String emailAddress;
    private String contactNo;
    private String location;
}
