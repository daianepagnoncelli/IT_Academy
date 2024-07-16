package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.impl;

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
        Player player = PlayerMapper.toEntity(playerDTO);
        player = playerRepository.save(player);
        return PlayerMapper.toDTO(player, gameRepository.findByIdPlayer(player.getId()));
    }

    @Override
    public Optional<PlayerDTO> getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
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
    public void deletePlayer(Long playerId) {
        gameRepository.deleteByIdPlayer(playerId);
        playerRepository.deleteById(playerId);
    }

    @Override
    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
        player.setName(playerDTO.getName());
        player = playerRepository.save(player);
        return PlayerMapper.toDTO(player, gameRepository.findByIdPlayer(player.getId()));
    }
}






