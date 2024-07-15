package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
