package dto.TM;

import javafx.scene.image.ImageView;
import lombok.*;

import javax.swing.table.TableColumn;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RoomTM {
    private String id;
    private ImageView food;
    private ImageView ac;
    private Double keyMoney;
    private int qty;
}
