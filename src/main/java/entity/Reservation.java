package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Reservation {
    @Id
    private String reservationId;
    private LocalDate date;
    private String studentId;
    private String roomTypeId;
    private String status;
}
