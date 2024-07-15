package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.controller;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.PlayerService;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @PutMapping
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @PostMapping("/{id}/games")
    public Game createGame(@PathVariable Long id) {
        return gameService.createGame(id);
    }

    @DeleteMapping("/{id}/games")
    public void deleteGames(@PathVariable Long id) {
        playerService.deleteAllGamesByPlayerId(id);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}/games")
    public List<Game> getGamesByPlayerId(@PathVariable Long id) {
        return gameService.getGamesByPlayerId(id);
    }
}

