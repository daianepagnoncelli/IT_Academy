package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.service;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.exception.ResourceNotFoundException;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.model.Game;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.model.Player;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.repository.GameRepository;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public Game rollDice(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new ResourceNotFoundException("Player not found"));

        Random random = new Random();
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        boolean win = (dice1 + dice2) == 7;

        Game game = new Game();
        game.setPlayer(player);
        game.setDice1(dice1);
        game.setDice2(dice2);
        game.setWin(win);
        game.setDateTime(LocalDateTime.now());

        return gameRepository.save(game);
    }

    public List<Game> getGamesByPlayer(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new ResourceNotFoundException("Player not found"));
        return player.getGames();
    }

    public void deleteGamesByPlayer(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new ResourceNotFoundException("Player not found"));
        gameRepository.deleteAll(player.getGames());
    }
}


