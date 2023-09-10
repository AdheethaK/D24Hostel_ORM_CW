package entity;

import jakarta.persistence.CascadeType;
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
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student studentId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Room roomTypeId;
    private String status;
}
