package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

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
    @OneToMany(mappedBy = "roomTypeId")
    private ArrayList<Reservation> reservations;
}
