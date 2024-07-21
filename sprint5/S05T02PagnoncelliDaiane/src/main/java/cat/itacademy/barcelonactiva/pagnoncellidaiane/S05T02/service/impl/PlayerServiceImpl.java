package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.impl;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.exception.PlayerAlreadyExistException;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.exception.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.mapper.PlayerMapper;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository.GameRepository;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    @Override
    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        logger.info("Creating player with name: {}", playerDTO.getName());
        if (playerRepository.findByName(playerDTO.getName()).isPresent()) {
            logger.error("Player with name {} already exists", playerDTO.getName());
            throw new PlayerAlreadyExistException("Player with name " + playerDTO.getName() + " already exists");
        }

        if (playerDTO.getName() == null || playerDTO.getName().trim().isEmpty()) {
            playerDTO.setName("ANONYMOUS");
        }
        Player player = PlayerMapper.toEntity(playerDTO);
        try {
            player = playerRepository.save(player);
            logger.info("Player created with ID: {}", player.getId());
            return PlayerMapper.toDTO(player, gameRepository.findByIdPlayer(player.getId()));
        } catch (Exception e) {
            logger.error("Error saving player: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Optional<PlayerDTO> getPlayerById(Long id) {
        logger.info("Fetching player with id: {}", id);
        Optional<Player> player = playerRepository.findById(id);
        if (player.isEmpty()) {
            logger.error("Player with id {} not found", id);
            throw new PlayerNotFoundException("Player with id " + id + " not found");
        }
        return player.map(p -> PlayerMapper.toDTO(p, gameRepository.findByIdPlayer(p.getId())));
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        logger.info("Fetching all players");
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(player -> PlayerMapper.toDTO(player, gameRepository.findByIdPlayer(player.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllGamesByPlayerId(Long playerId) {
        logger.info("Deleting all games for player with id: {}", playerId);
        if (!playerRepository.existsById(playerId)) {
            logger.error("Player with id {} not found", playerId);
            throw new PlayerNotFoundException("Player with id " + playerId + " not found");
        }
        try {
            gameRepository.deleteByIdPlayer(playerId);
            logger.info("Games deleted for player with id: {}", playerId);
        } catch (Exception e) {
            logger.error("Error deleting games for player: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        logger.info("Updating player with id: {}", id);
        Optional<Player> playerOpt = playerRepository.findById(id);
        if (playerOpt.isEmpty()) {
            logger.error("Player with id {} not found", id);
            throw new PlayerNotFoundException("Player with id " + id + " not found");
        }
        Player player = playerOpt.get();
        if (playerDTO.getName() != null && !playerDTO.getName().trim().isEmpty()) {
            player.setName(playerDTO.getName());
        }
        try {
            player = playerRepository.save(player);
            logger.info("Player updated with ID: {}", player.getId());
            return PlayerMapper.toDTO(player, gameRepository.findByIdPlayer(player.getId()));
        } catch (Exception e) {
            logger.error("Error updating player: {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deletePlayer(Long id) {
        logger.info("Deleting player with id: {}", id);
        if (!playerRepository.existsById(id)) {
            logger.error("Player with id {} not found", id);
            throw new PlayerNotFoundException("Player with id " + id + " not found");
        }
        try {
            playerRepository.deleteById(id);
            logger.info("Player deleted with id: {}", id);
        } catch (Exception e) {
            logger.error("Error deleting player: {}", e.getMessage(), e);
            throw e;
        }
    }
}












