package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.services;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.exceptions.FruitAlreadyExistsException;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.domain.Fruit;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit getFruitById(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit not found with id " + id));
    }

    public Fruit addFruit(Fruit fruit) {
        if (fruit.getId() != 0 && fruitRepository.existsById(fruit.getId())) {
            throw new FruitAlreadyExistsException("Fruit already exists with id " + fruit.getId());
        }
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Fruit fruit) {
        if (!fruitRepository.existsById(fruit.getId())) {
            throw new FruitNotFoundException("Fruit not found with id " + fruit.getId());
        }
        return fruitRepository.save(fruit);
    }

    public void deleteFruit(int id) {
        if (!fruitRepository.existsById(id)) {
            throw new FruitNotFoundException("Fruit not found with id " + id);
        }
        fruitRepository.deleteById(id);
    }
}
