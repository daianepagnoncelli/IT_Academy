package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t01.n01.model.services.BranchService;

@Controller
public class WebController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/branch/list")
    public String listBranches(Model model) {
        model.addAttribute("branches", branchService.getAllBranches());
        return "branchList";
    }
}
