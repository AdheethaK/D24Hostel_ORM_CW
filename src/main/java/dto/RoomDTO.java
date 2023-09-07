package dto;

import lombok.*;

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
