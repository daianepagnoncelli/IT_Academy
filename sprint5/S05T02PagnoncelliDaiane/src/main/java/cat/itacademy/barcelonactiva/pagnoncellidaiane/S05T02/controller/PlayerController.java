package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.controller;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.PlayerService;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Comparator;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @PostMapping
    public PlayerDTO createPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.createPlayer(playerDTO);
    }

    @PutMapping
    public PlayerDTO updatePlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.createPlayer(playerDTO);
    }

    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}/games")
    public List<GameDTO> getGamesByPlayerId(@PathVariable Long id) {
        return gameService.getGamesByPlayerId(id);
    }

    @GetMapping("/ranking")
    public double getAverageSuccessRate() {
        List<PlayerDTO> players = playerService.getAllPlayers();
        OptionalDouble averageSuccessRate = players.stream()
                .mapToDouble(PlayerDTO::getSuccessRate)
                .average();
        return averageSuccessRate.orElse(0.0);
    }

    @GetMapping("/ranking/loser")
    public PlayerDTO getPlayerWithLowestSuccessRate() {
        return playerService.getAllPlayers().stream()
                .min(Comparator.comparingDouble(PlayerDTO::getSuccessRate))
                .orElse(null);
    }

    @GetMapping("/ranking/winner")
    public PlayerDTO getPlayerWithHighestSuccessRate() {
        return playerService.getAllPlayers().stream()
                .max(Comparator.comparingDouble(PlayerDTO::getSuccessRate))
                .orElse(null);
    }
}



