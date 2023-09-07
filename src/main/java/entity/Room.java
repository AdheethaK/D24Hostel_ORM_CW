package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Room {
    @Id
    private String roomTypeId;
    private boolean typeFOOD;
    private boolean typeAC;
    private Double keyMoney;
    private Integer qty;
}
