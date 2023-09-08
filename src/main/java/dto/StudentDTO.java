package dto;

import entity.Reservation;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {
    private String id;
    private String name;
    private String address;
    private String contactNo;
    private LocalDate dob;
    private String gender;
}
