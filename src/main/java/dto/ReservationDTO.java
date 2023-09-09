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
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private StudentDTO studentId;
    private RoomDTO roomTypeId;
    private String status;
}
