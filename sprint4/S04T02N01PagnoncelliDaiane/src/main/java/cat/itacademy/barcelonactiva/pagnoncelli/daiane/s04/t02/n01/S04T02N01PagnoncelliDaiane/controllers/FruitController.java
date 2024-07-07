package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.controllers;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.domain.Fruit;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s04.t02.n01.S04T02N01PagnoncelliDaiane.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        return ResponseEntity.ok(fruitService.getAllFruits());
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable int id) {
        Fruit fruit = fruitService.getFruitById(id);
        return ResponseEntity.ok(fruit);
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        Fruit newFruit = fruitService.addFruit(fruit);
        return ResponseEntity.ok(newFruit);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.updateFruit(fruit);
        return ResponseEntity.ok(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable int id) {
        fruitService.deleteFruit(id);
        return ResponseEntity.noContent().build();
    }
}

