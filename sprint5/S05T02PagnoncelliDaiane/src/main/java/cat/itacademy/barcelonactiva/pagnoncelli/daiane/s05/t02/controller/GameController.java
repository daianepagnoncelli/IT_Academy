package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.controller;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.model.Game;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players/{playerId}/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<Game> rollDice(@PathVariable Long playerId) {
        Game game = gameService.rollDice(playerId);
        return ResponseEntity.ok(game);
    }

    @GetMapping
    public ResponseEntity<List<Game>> getGamesByPlayer(@PathVariable Long playerId) {
        List<Game> games = gameService.getGamesByPlayer(playerId);
        return ResponseEntity.ok(games);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteGamesByPlayer(@PathVariable Long playerId) {
        gameService.deleteGamesByPlayer(playerId);
        return ResponseEntity.noContent().build();
    }
}

