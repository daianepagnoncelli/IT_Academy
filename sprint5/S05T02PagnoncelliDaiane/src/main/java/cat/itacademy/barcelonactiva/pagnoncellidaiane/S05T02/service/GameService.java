package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.GameDTO;

import java.util.List;

public interface GameService {
    GameDTO createGame(Long playerId);
    void deleteAllGamesByPlayerId(Long playerId);
    List<GameDTO> getGamesByPlayerId(Long playerId);
    GameDTO getGameById(String id);
}





