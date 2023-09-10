package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String emailAddress;
    private String contactNo;
    private String location;
}
