package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.mapper;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;

public class GameMapper {

    public static Game toEntity(GameDTO gameDTO) {
        return new Game(gameDTO.getId(), gameDTO.getDice1(), gameDTO.getDice2(), gameDTO.isWin(), gameDTO.getIdPlayer());
    }

    public static GameDTO toDTO(Game game) {
        return new GameDTO(game.getId(), game.getDice1(), game.getDice2(), game.isWin(), game.getIdPlayer());
    }
}




