package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int dice1;
    private int dice2;
    private boolean isWin;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
