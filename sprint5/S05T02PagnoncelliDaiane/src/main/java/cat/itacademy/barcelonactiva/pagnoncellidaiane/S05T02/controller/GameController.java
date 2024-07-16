package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.controller;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.GameService;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @Autowired
    private PlayerService playerService;

    @PostMapping("/newGame/{idPlayer}")
    public ResponseEntity<String> newGame(@PathVariable long idPlayer) {
        GameDTO gameDTO = gameService.createGame(idPlayer);
        String result = gameDTO.isWin() ? "You Win!!" : "You lose.";
        return ResponseEntity.ok(result + "\n " + gameDTO.getDice1() + " + " + gameDTO.getDice2());
    }

    @DeleteMapping("/deleteAllGames/{idPlayer}")
    public ResponseEntity<String> deleteAllGames(@PathVariable long idPlayer) {
        gameService.deleteAllGamesByPlayerId(idPlayer);
        return ResponseEntity.ok("All games deleted for player with ID: " + idPlayer);
    }

    @GetMapping("/getOneGame/{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable String id) {
        GameDTO gameDTO = gameService.getGameById(id);
        return ResponseEntity.ok(gameDTO);
    }

    @GetMapping("/getAllGames/{idPlayer}")
    public ResponseEntity<List<GameDTO>> getAllGames(@PathVariable long idPlayer) {
        List<GameDTO> games = gameService.getGamesByPlayerId(idPlayer);
        return ResponseEntity.ok(games);
    }
}




