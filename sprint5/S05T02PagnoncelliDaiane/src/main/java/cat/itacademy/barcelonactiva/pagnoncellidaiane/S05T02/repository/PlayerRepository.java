package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByName(String name);
}


