package dto.TM;

import lombok.*;

import javafx.scene.image.ImageView;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReservationTM {
    private String reservationId;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String studentId;
    private String roomTypeId;
    private ImageView status;
}
