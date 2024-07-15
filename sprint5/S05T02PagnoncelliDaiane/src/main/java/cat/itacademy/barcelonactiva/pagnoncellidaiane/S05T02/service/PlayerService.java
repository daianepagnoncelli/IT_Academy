package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    Player createPlayer(Player player);
    Optional<Player> getPlayerById(Long id);
    List<Player> getAllPlayers();
    void deleteAllGamesByPlayerId(Long playerId);
}
