package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping
    public String viewBranches(Model model) {
        List<BranchDTO> branchList = branchService.getAllBranches();
        model.addAttribute("branchList", branchList);
        model.addAttribute("branch", new BranchDTO());
        return "branchForm";
    }

    @PostMapping("/add")
    public String addBranch(@ModelAttribute("branch") BranchDTO branchDTO) {
        branchService.saveBranch(branchDTO);
        return "redirect:/branch";
    }

    @GetMapping("/edit/{id}")
    public String editBranch(@PathVariable int id, Model model) {
        BranchDTO branch = branchService.getOneBranch(id);
        model.addAttribute("branch", branch);
        return "editBranch";
    }

    @PostMapping("/update")
    public String updateBranch(@ModelAttribute("branch") BranchDTO branchDTO) {
        branchService.updateBranch(branchDTO.getPk_BranchID(), branchDTO);
        return "redirect:/branch";
    }

    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable int id) {
        branchService.deleteBranch(id);
        return "redirect:/branch";
    }
}








