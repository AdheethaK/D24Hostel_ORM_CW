package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    private Student studentId;
    @ManyToOne
    private Room roomTypeId;
    private String status;
}
