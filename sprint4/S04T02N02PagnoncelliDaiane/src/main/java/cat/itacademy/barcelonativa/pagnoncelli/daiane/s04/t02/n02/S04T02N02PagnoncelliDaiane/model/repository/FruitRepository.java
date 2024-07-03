package cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.model.repository;

import cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
}
