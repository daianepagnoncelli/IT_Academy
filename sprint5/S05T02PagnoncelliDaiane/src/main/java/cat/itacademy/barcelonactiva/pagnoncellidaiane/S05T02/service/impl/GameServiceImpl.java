package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.impl;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.mapper.GameMapper;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository.GameRepository;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public GameDTO createGame(Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            Random random = new Random();
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            boolean isWin = (dice1 + dice2) == 7;

            Game game = new Game();
            game.setDice1(dice1);
            game.setDice2(dice2);
            game.setWin(isWin);
            game.setPlayer(player.get());

            game = gameRepository.save(game);
            return GameMapper.toDTO(game);
        } else {
            throw new RuntimeException("Player not found");
        }
    }

    @Override
    public List<GameDTO> getGamesByPlayerId(Long playerId) {
        List<Game> games = gameRepository.findByPlayerId(playerId);
        return games.stream()
                .map(GameMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllGamesByPlayerId(Long playerId) {
        gameRepository.deleteAll(gameRepository.findByPlayerId(playerId));
    }
}



