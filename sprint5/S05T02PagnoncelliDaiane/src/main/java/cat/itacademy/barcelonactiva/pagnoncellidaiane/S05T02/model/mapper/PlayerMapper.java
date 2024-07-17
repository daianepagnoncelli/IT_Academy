package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.mapper;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;

import java.util.List;

public class PlayerMapper {

    public static Player toEntity(PlayerDTO playerDTO) {
        String name = playerDTO.getName();
        if (name == null || name.trim().isEmpty()) {
            name = "ANONYMOUS";
        }
        return new Player(name);
    }

    public static PlayerDTO toDTO(Player player, List<Game> games) {
        PlayerDTO playerDTO = new PlayerDTO(player.getName());
        if (player.getName().isEmpty()) {
            playerDTO.setName("ANONYMOUS");
        }
        playerDTO.setId(player.getId());
        playerDTO.setSignDate(player.getSignDate());
        playerDTO.setWinRate(games);
        return playerDTO;
    }
}







