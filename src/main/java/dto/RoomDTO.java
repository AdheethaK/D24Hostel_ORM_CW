package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomDTO {
    private String roomTypeId;
    private String type;
    private Double keyMoney;
    private Integer qty;
}
