package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.controller;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private static final Logger logger = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO) {
        logger.info("Creating a new player: {}", playerDTO.getName());
        try {
            PlayerDTO createdPlayer = playerService.createPlayer(playerDTO);
            logger.info("Player created successfully: {}", createdPlayer);
            return ResponseEntity.ok(createdPlayer);
        } catch (Exception e) {
            logger.error("Error creating player: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        logger.info("Updating player with id: {}", id);
        try {
            PlayerDTO updatedPlayer = playerService.updatePlayer(id, playerDTO);
            logger.info("Player updated successfully: {}", updatedPlayer);
            return ResponseEntity.ok(updatedPlayer);
        } catch (Exception e) {
            logger.error("Error updating player: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        logger.info("Deleting player with id: {}", id);
        try {
            playerService.deletePlayer(id);
            logger.info("Player deleted successfully with id: {}", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting player: {}", e.getMessage(), e);
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id) {
        logger.info("Fetching player with id: {}", id);
        try {
            PlayerDTO playerDTO = playerService.getPlayerById(id).orElseThrow(() -> new RuntimeException("Player not found"));
            logger.info("Player fetched successfully: {}", playerDTO);
            return ResponseEntity.ok(playerDTO);
        } catch (Exception e) {
            logger.error("Error fetching player: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        logger.info("Fetching all players");
        try {
            List<PlayerDTO> players = playerService.getAllPlayers();
            logger.info("Players fetched successfully");
            return ResponseEntity.ok(players);
        } catch (Exception e) {
            logger.error("Error fetching players: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/ranking")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Double> getAverageSuccessRate() {
        logger.info("Fetching average success rate of all players");
        try {
            List<PlayerDTO> players = playerService.getAllPlayers();
            double averageSuccessRate = players.stream().mapToDouble(PlayerDTO::getSuccessRate).average().orElse(0.0);
            logger.info("Average success rate fetched successfully: {}", averageSuccessRate);
            return ResponseEntity.ok(averageSuccessRate);
        } catch (Exception e) {
            logger.error("Error fetching average success rate: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/ranking/loser")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PlayerDTO> getLoser() {
        logger.info("Fetching the player with the lowest success rate");
        try {
            List<PlayerDTO> players = playerService.getAllPlayers();
            PlayerDTO loser = players.stream().min((p1, p2) -> Double.compare(p1.getSuccessRate(), p2.getSuccessRate())).orElse(null);
            logger.info("Player with the lowest success rate fetched successfully: {}", loser);
            return ResponseEntity.ok(loser);
        } catch (Exception e) {
            logger.error("Error fetching player with the lowest success rate: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/ranking/winner")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PlayerDTO> getWinner() {
        logger.info("Fetching the player with the highest success rate");
        try {
            List<PlayerDTO> players = playerService.getAllPlayers();
            PlayerDTO winner = players.stream().max((p1, p2) -> Double.compare(p1.getSuccessRate(), p2.getSuccessRate())).orElse(null);
            logger.info("Player with the highest success rate fetched successfully: {}", winner);
            return ResponseEntity.ok(winner);
        } catch (Exception e) {
            logger.error("Error fetching player with the highest success rate: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}/games")
    public ResponseEntity<Void> deletePlayerGames(@PathVariable Long id) {
        logger.info("Deleting games for player with id: {}", id);
        try {
            playerService.deleteAllGamesByPlayerId(id);
            logger.info("Games deleted successfully for player with id: {}", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting games for player: {}", e.getMessage(), e);
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}/all")
    public ResponseEntity<Void> deletePlayerAndGames(@PathVariable Long id) {
        logger.info("Deleting player and their games with id: {}", id);
        try {
            playerService.deleteAllGamesByPlayerId(id);
            playerService.deletePlayer(id);
            logger.info("Player and their games deleted successfully with id: {}", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting player and their games: {}", e.getMessage(), e);
            return ResponseEntity.status(500).build();
        }
    }
}









