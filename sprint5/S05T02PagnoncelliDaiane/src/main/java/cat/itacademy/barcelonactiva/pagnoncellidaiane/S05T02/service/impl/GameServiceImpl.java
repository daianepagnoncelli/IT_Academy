package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.impl;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.mapper.GameMapper;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository.GameRepository;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public GameDTO createGame(Long playerId) {
        checkPlayerId(playerId);
        Game game = new Game(playerId);  // Aqui estamos utilizando o construtor
        gameRepository.save(game);
        return GameMapper.toDTO(game);
    }

    @Override
    public void deleteAllGamesByPlayerId(Long playerId) {
        checkPlayerId(playerId);
        gameRepository.deleteByIdPlayer(playerId);
    }

    @Override
    public List<GameDTO> getGamesByPlayerId(Long playerId) {
        checkPlayerId(playerId);
        return gameRepository.findByIdPlayer(playerId).stream()
                .map(GameMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GameDTO getGameById(String id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));
        return GameMapper.toDTO(game);
    }

    private void checkPlayerId(Long playerId) {
        playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found with id " + playerId));
    }
}











