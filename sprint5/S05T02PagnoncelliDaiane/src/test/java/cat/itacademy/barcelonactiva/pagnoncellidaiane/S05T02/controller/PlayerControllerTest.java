package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.controller;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.PlayerService;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.config.JwtService;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(
        controllers = PlayerController.class,
        excludeAutoConfiguration = {
                UserDetailsServiceAutoConfiguration.class,
                SecurityAutoConfiguration.class,
                JpaRepositoriesAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class
        }
)
@ContextConfiguration(classes = PlayerController.class)
public class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private UserServiceImpl userService;

    @Autowired
    private ObjectMapper objectMapper;

    private PlayerDTO player1;
    private PlayerDTO player2;

    @BeforeEach
    void setUp() {
        player1 = PlayerDTO.builder()
                .id(1L)
                .name("Player1")
                .build();
        player2 = PlayerDTO.builder()
                .id(2L)
                .name("Player2")
                .build();
    }

    @AfterEach
    void tearDown() {
        player1 = player2 = null;
    }

    @DisplayName("PlayerControllerTest - Test return players list")
    @Test
    void should_return_player_list() throws Exception {
        when(playerService.getAllPlayers()).thenReturn(Arrays.asList(player1, player2));
        mockMvc.perform(get("/players"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$").isArray());
    }

    @DisplayName("PlayerControllerTest - Test return player by id")
    @Test
    void should_return_player() throws Exception {
        when(playerService.getPlayerById(1L)).thenReturn(java.util.Optional.ofNullable(player1));
        mockMvc.perform(get("/players/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(player1.getId().intValue())))
                .andExpect(jsonPath("$.name", is(player1.getName())))
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @DisplayName("PlayerControllerTest - Test for insert new player")
    @Test
    void should_add_new_player() throws Exception {
        when(playerService.createPlayer(any(PlayerDTO.class))).thenReturn(player1);
        String playerJson = "{\"id\":1,\"name\":\"Player1\"}";

        mockMvc.perform(post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(playerJson)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(player1.getId().intValue())))
                .andExpect(jsonPath("$.name", is(player1.getName())))
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @DisplayName("PlayerControllerTest - Test for update player")
    @Test
    void should_update_existing_player() throws Exception {
        PlayerDTO updatedPlayer = PlayerDTO.builder().id(2L).name("UpdatedPlayer").build();
        when(playerService.updatePlayer(any(Long.class), any(PlayerDTO.class))).thenReturn(updatedPlayer);

        String updatedPlayerJson = "{\"id\":2,\"name\":\"UpdatedPlayer\"}";

        mockMvc.perform(put("/players/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedPlayerJson)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.name", is("UpdatedPlayer")))
                .andExpect(jsonPath("$").isNotEmpty());
    }

    @DisplayName("PlayerControllerTest - Test for delete player by id")
    @Test
    void should_remove_player() throws Exception {
        mockMvc.perform(delete("/players/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}







