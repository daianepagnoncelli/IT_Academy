package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private String name;
    private Date signDate;
    private double winRate;

    public PlayerDTO(String name) {
        this.name = name;
    }

    public void setWinRate(List<Game> games) {
        if (games == null || games.isEmpty()) {
            this.winRate = 0;
        } else {
            long wins = games.stream().filter(Game::isWin).count();
            this.winRate = (double) wins / games.size() * 100;
        }
    }

    public double getSuccessRate() {
        return this.winRate;
    }
}






