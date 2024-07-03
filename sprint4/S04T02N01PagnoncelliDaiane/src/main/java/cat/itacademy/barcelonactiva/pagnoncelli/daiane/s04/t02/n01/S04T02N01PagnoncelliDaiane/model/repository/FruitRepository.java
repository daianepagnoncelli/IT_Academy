package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.repository;


import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
