package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.services;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.domain.Fruit;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Optional<Fruit> getFruitById(int id) {
        return fruitRepository.findById(id);
    }

    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public void deleteFruit(int id) {
        fruitRepository.deleteById(id);
    }
}
