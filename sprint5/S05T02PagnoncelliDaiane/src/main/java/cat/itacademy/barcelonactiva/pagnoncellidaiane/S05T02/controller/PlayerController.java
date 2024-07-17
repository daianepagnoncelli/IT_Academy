package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.controller;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO createdPlayer = playerService.createPlayer(playerDTO);
        return ResponseEntity.ok(createdPlayer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        PlayerDTO updatedPlayer = playerService.updatePlayer(id, playerDTO);
        return ResponseEntity.ok(updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        PlayerDTO playerDTO = playerService.getPlayerById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        return ResponseEntity.ok(playerDTO);
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<PlayerDTO> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/ranking")
    public ResponseEntity<Double> getAverageSuccessRate() {
        List<PlayerDTO> players = playerService.getAllPlayers();
        double averageSuccessRate = players.stream().mapToDouble(PlayerDTO::getSuccessRate).average().orElse(0.0);
        return ResponseEntity.ok(averageSuccessRate);
    }

    @GetMapping("/ranking/loser")
    public ResponseEntity<PlayerDTO> getLoser() {
        List<PlayerDTO> players = playerService.getAllPlayers();
        PlayerDTO loser = players.stream().min((p1, p2) -> Double.compare(p1.getSuccessRate(), p2.getSuccessRate())).orElse(null);
        return ResponseEntity.ok(loser);
    }

    @GetMapping("/ranking/winner")
    public ResponseEntity<PlayerDTO> getWinner() {
        List<PlayerDTO> players = playerService.getAllPlayers();
        PlayerDTO winner = players.stream().max((p1, p2) -> Double.compare(p1.getSuccessRate(), p2.getSuccessRate())).orElse(null);
        return ResponseEntity.ok(winner);
    }

    @DeleteMapping("/{id}/games")
    public ResponseEntity<Void> deletePlayerAndGames(@PathVariable Long id) {
        playerService.deleteAllGamesByPlayerId(id);
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}






