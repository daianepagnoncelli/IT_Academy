package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    private String id;
    private int dice1;
    private int dice2;
    private boolean isWin;
    private Long idPlayer;

    public Game(Long idPlayer) {
        this.idPlayer = idPlayer;
        this.dice1 = (int) (Math.random() * 6) + 1;
        this.dice2 = (int) (Math.random() * 6) + 1;
        this.isWin = this.dice1 + this.dice2 == 7;
    }
}





