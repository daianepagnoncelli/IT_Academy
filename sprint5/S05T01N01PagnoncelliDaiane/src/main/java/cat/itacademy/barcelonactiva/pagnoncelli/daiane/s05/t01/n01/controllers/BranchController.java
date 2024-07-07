package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping(path = "/add")
    public ResponseEntity<BranchDTO> saveBranch(@RequestBody BranchDTO branchDto) {
        branchService.saveBranch(branchDto);
        return new ResponseEntity<>(branchDto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<BranchDTO> updateBranch(@PathVariable int id, @RequestBody BranchDTO branchDto) {
        return new ResponseEntity<>(branchService.updateBranch(id, branchDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable int id) {
        branchService.deleteBranch(id);
        return new ResponseEntity<>("Branch id " + id + " deleted successfully", HttpStatus.OK);
    }

    @GetMapping(path = "/getOne/{id}")
    public ResponseEntity<BranchDTO> getOneBranch(@PathVariable int id) {
        return new ResponseEntity<>(branchService.getOneBranch(id), HttpStatus.OK);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<BranchDTO>> getAllBranches() {
        return new ResponseEntity<>(branchService.getAllBranches(), HttpStatus.OK);
    }
}




