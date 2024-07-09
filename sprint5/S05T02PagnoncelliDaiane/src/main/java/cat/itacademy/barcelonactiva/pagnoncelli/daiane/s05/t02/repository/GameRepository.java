package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.repository;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
