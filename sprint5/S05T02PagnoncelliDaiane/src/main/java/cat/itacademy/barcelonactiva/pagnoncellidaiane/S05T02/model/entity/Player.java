package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date signDate;

    public Player(String name) {
        this.name = name;
        this.signDate = new Date();
    }
}






