package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;

import java.util.List;

public interface GameService {
    Game createGame(Long playerId);
    List<Game> getGamesByPlayerId(Long playerId);
}

