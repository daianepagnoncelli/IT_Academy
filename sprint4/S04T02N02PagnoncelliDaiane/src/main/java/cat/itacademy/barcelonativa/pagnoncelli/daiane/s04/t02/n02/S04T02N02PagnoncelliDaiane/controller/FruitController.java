package cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.controller;

import cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.model.domain.Fruit;
import cat.itacademy.barcelonativa.pagnoncelli.daiane.s04.t02.n02.S04T02N02PagnoncelliDaiane.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping
    public List<Fruit> getAllFruits() {
        return fruitService.getAllFruits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id) {
        Fruit fruit = fruitService.getFruitById(id);
        return ResponseEntity.ok(fruit);
    }

    @PostMapping
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        Fruit newFruit = fruitService.addFruit(fruit);
        return ResponseEntity.ok(newFruit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable Long id) {
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }
}

