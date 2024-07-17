package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.impl;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.exception.GameNotFoundException;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.mapper.GameMapper;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository.GameRepository;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public GameDTO createGame(Long playerId) {
        Random random = new Random();
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        boolean isWin = (dice1 + dice2) == 7;

        Game game = new Game();
        game.setDice1(dice1);
        game.setDice2(dice2);
        game.setWin(isWin);
        game.setIdPlayer(playerId);

        game = gameRepository.save(game);
        return GameMapper.toDTO(game);
    }

    @Override
    public List<GameDTO> getGamesByPlayerId(Long playerId) {
        List<Game> games = gameRepository.findByIdPlayer(playerId);
        if (games.isEmpty()) {
            throw new GameNotFoundException("No games found for player with id " + playerId);
        }
        return games.stream().map(GameMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteAllGamesByPlayerId(Long playerId) {
        if (gameRepository.findByIdPlayer(playerId).isEmpty()) {
            throw new GameNotFoundException("No games found for player with id " + playerId);
        }
        gameRepository.deleteByIdPlayer(playerId);
    }

    @Override
    public GameDTO getGameById(String id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException("Game not found with id " + id));
        return GameMapper.toDTO(game);
    }
}













