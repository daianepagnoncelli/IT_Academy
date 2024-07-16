package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.repository;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    List<Game> findByIdPlayer(Long idPlayer);
    void deleteByIdPlayer(Long idPlayer);
}






