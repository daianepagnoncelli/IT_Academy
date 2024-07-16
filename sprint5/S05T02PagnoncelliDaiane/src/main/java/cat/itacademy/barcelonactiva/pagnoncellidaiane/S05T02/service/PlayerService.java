package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    PlayerDTO createPlayer(PlayerDTO playerDTO);
    PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO);
    void deletePlayer(Long id);
    Optional<PlayerDTO> getPlayerById(Long id);
    List<PlayerDTO> getAllPlayers();
}


