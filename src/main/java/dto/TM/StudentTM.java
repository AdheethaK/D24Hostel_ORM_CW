package dto.TM;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentTM {
    private String id;
    private String name;
    private String address;
    private String contactNo;
    private LocalDate dob;
    private String gender;
}
