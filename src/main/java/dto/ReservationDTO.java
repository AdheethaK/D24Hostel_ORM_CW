package dto;

import entity.Room;
import entity.Student;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReservationDTO {
    private String reservationId;
    private LocalDate date;
    private Student studentId;
    private Room roomTypeId;
    private String status;
}
