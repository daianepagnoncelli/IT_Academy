package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n02.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n02.model.services.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {

    @Autowired
    private FlorService florService;

    @PostMapping("/add")
    public ResponseEntity<FlorDTO> addFlor(@RequestBody FlorDTO florDTO) {
        return ResponseEntity.ok(florService.saveFlor(florDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<FlorDTO> updateFlor(@RequestBody FlorDTO florDTO) {
        return ResponseEntity.ok(florService.updateFlor(florDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlor(@PathVariable Integer id) {
        florService.deleteFlor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorDTO> getOneFlor(@PathVariable Integer id) {
        return ResponseEntity.ok(florService.getFlor(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlorDTO>> getAllFlor() {
        return ResponseEntity.ok(florService.getAllFlor());
    }
}


