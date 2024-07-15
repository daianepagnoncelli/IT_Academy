package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.mapper;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;

import java.util.List;

public class PlayerMapper {

    public static Player toEntity(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setName(playerDTO.getName());
        return player;
    }

    public static PlayerDTO toDTO(Player player, List<Game> games) {
        double winRate = calculateWinRate(games);
        return new PlayerDTO(player.getId(), player.getName(), player.getRegistrationDate(), winRate);
    }

    private static double calculateWinRate(List<Game> games) {
        if (games.isEmpty()) {
            return 0;
        }
        long winCount = games.stream().filter(Game::isWin).count();
        return (double) winCount / games.size() * 100;
    }
}

