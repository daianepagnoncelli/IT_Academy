package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.service;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.exception.ResourceNotFoundException;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.model.Player;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player player) {
        player.setRegistrationDate(LocalDate.now());
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Player not found"));
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Player updatePlayerName(Long id, String newName) {
        Player player = getPlayerById(id);
        player.setName(newName);
        return playerRepository.save(player);
    }
}


