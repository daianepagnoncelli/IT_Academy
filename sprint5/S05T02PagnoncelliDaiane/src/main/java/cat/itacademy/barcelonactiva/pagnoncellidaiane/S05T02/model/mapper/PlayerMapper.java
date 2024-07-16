package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.mapper;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;

import java.util.List;

public class PlayerMapper {

    public static Player toEntity(PlayerDTO playerDTO) {
        return new Player(playerDTO.getName());
    }

    public static PlayerDTO toDTO(Player player, List<Game> games) {
        PlayerDTO playerDTO = new PlayerDTO(player.getName());
        playerDTO.setId(player.getId());
        playerDTO.setSignDate(player.getSignDate());
        playerDTO.setWinRate(games);
        return playerDTO;
    }
}






