package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByPlayerId(Long playerId);
}

