package dto;

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
    private String studentId;
    private String roomTypeId;
    private String status;
}
