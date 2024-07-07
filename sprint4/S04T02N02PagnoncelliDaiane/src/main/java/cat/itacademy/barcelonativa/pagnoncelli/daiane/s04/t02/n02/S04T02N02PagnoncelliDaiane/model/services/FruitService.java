package cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.model.services;

import cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.exception.FruitAlreadyExistsException;
import cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.exception.FruitNotFoundException;
import cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.model.domain.Fruit;
import cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.model.repository.FruitRepository;
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

    public Fruit getFruitById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit not found with id: " + id));
    }

    public Fruit addFruit(Fruit fruit) {
        Optional<Fruit> existingFruit = fruitRepository.findByName(fruit.getName());
        if (existingFruit.isPresent()) {
            throw new FruitAlreadyExistsException("Fruit already exists with name: " + fruit.getName());
        }
        return fruitRepository.save(fruit);
    }

    public void deleteFruit(Long id) {
        Fruit fruit = fruitRepository.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit not found with id: " + id));
        fruitRepository.delete(fruit);
    }
}


