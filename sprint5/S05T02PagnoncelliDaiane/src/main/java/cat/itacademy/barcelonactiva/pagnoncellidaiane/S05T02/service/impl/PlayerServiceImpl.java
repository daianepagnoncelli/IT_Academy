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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    @Override
    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        if (playerRepository.findByName(playerDTO.getName()).isPresent()) {
            throw new PlayerAlreadyExistException("Player with name " + playerDTO.getName() + " already exists");
        }

        if (playerDTO.getName() == null || playerDTO.getName().trim().isEmpty()) {
            playerDTO.setName("ANONYMOUS");
        }
        Player player = PlayerMapper.toEntity(playerDTO);
        player = playerRepository.save(player);
        return PlayerMapper.toDTO(player, gameRepository.findByIdPlayer(player.getId()));
    }

    @Override
    public Optional<PlayerDTO> getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if (!player.isPresent()) {
            throw new PlayerNotFoundException("Player with id " + id + " not found");
        }
        return player.map(p -> PlayerMapper.toDTO(p, gameRepository.findByIdPlayer(p.getId())));
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(player -> PlayerMapper.toDTO(player, gameRepository.findByIdPlayer(player.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllGamesByPlayerId(Long playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new PlayerNotFoundException("Player with id " + playerId + " not found");
        }
        gameRepository.deleteByIdPlayer(playerId);
    }

    @Override
    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        Optional<Player> playerOpt = playerRepository.findById(id);
        if (!playerOpt.isPresent()) {
            throw new PlayerNotFoundException("Player with id " + id + " not found");
        }
        Player player = playerOpt.get();
        if (playerDTO.getName() != null && !playerDTO.getName().trim().isEmpty()) {
            player.setName(playerDTO.getName());
        }
        player = playerRepository.save(player);
        return PlayerMapper.toDTO(player, gameRepository.findByIdPlayer(player.getId()));
    }

    @Override
    public void deletePlayer(Long id) {
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotFoundException("Player with id " + id + " not found");
        }
        playerRepository.deleteById(id);
    }
}











