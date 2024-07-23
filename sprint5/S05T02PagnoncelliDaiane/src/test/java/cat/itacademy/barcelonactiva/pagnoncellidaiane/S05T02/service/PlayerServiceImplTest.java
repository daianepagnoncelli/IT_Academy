package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.exception.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository.GameRepository;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.impl.PlayerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        player1 = Player.builder()
                .id(1L).name("Player 1")
                .build();
        player2 = Player.builder()
                .id(2L)
                .name("Player 2")
                .build();
    }

    @DisplayName("PlayerServiceTest - Test return players list")
    @Test
    void return_players_list() {
        when(playerRepository.findAll()).thenReturn(Arrays.asList(player1, player2));
        List<PlayerDTO> playersList = playerService.getAllPlayers();
        assertEquals(2, playersList.size());
        verify(playerRepository).findAll();
    }

    @DisplayName("PlayerServiceTest - Test return player by id")
    @Test
    void return_player_by_id() {
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player1));
        PlayerDTO returnedPlayer = playerService.getPlayerById(1L).orElse(null);
        assertNotNull(returnedPlayer);
        assertEquals(player1.getId(), returnedPlayer.getId());
        assertEquals(player1.getName(), returnedPlayer.getName());
        verify(playerRepository).findById(1L);
    }

    @DisplayName("PlayerServiceTest - Test create new player")
    @Test
    void create_new_player() {
        when(playerRepository.save(any(Player.class))).thenReturn(player1);
        PlayerDTO createdPlayer = playerService.createPlayer(PlayerDTO.builder().name("Player 1").build());
        assertNotNull(createdPlayer);
        assertEquals(player1.getName(), createdPlayer.getName());
        verify(playerRepository).save(any(Player.class));
    }

    @DisplayName("PlayerServiceTest - Test update player")
    @Test
    void update_player() {
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player1));
        when(playerRepository.save(any(Player.class))).thenReturn(player1);
        PlayerDTO updatedPlayer = playerService.updatePlayer(1L, PlayerDTO.builder().name("Updated Player").build());
        assertNotNull(updatedPlayer);
        assertEquals("Updated Player", updatedPlayer.getName());
        verify(playerRepository).save(any(Player.class));
    }

    @DisplayName("PlayerServiceTest - Test delete player by id")
    @Test
    void delete_player_by_id() {
        when(playerRepository.existsById(1L)).thenReturn(true);
        doNothing().when(playerRepository).deleteById(1L);
        playerService.deletePlayer(1L);
        verify(playerRepository, times(1)).deleteById(1L);
    }

    @DisplayName("PlayerServiceTest - Test delete player by id not found")
    @Test
    void throw_exception_when_delete_nonexistent_player() {
        when(playerRepository.existsById(1L)).thenReturn(false);
        Exception exception = assertThrows(PlayerNotFoundException.class, () -> {
            playerService.deletePlayer(1L);
        });
        assertEquals("Player with id 1 not found", exception.getMessage());
        verify(playerRepository, never()).deleteById(1L);
    }
}





