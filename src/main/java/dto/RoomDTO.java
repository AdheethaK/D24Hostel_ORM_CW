package dto;

import entity.Reservation;
import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomDTO {
    private String roomTypeId;
    private boolean typeFOOD;
    private boolean typeAC;
    private Double keyMoney;
    private Integer qty;
}
