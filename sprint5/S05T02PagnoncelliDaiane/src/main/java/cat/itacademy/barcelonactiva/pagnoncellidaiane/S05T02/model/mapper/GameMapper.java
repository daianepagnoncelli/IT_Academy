package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.mapper;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;

public class GameMapper {

    public static Game toEntity(GameDTO gameDTO) {
        Game game = new Game();
        game.setDice1(gameDTO.getDice1());
        game.setDice2(gameDTO.getDice2());
        game.setWin(gameDTO.isWin());
        return game;
    }

    public static GameDTO toDTO(Game game) {
        return new GameDTO(game.getId(), game.getDice1(), game.getDice2(), game.isWin());
    }
}

