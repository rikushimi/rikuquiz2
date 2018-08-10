package com.example.rikuquiz.controller;

import com.example.rikuquiz.domain.Riku;
import com.example.rikuquiz.service.RikuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/riku")
public class RikuController {

    @Autowired
    private RikuService rikuService;

    @GetMapping()
    private String index(Model model){
        List<Riku> rikus= rikuService.findAll();
        model.addAttribute("rikus",rikus);
        return "riku/index";
    }

    @GetMapping("new")
    public String newRiku(Model model){
        return "riku/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Riku riku = rikuService.findOne(id);
        model.addAttribute("riku", riku);
        return "riku/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model){
        Riku riku = rikuService.findOne(id);
        model.addAttribute("riku", riku);
        return"riku/show";
    }

    @PostMapping
    public String create(@ModelAttribute Riku riku){
        rikuService.save(riku);
        return "redirect:/riku";
    }

    @GetMapping("{id}/happy")
    public String happy(@PathVariable Long id, Model model){
        Riku riku = rikuService.findOne(id);
        model.addAttribute("riku", riku);
        return "riku/happy";
    }

    @GetMapping("{id}/bad")
    public String bad(@PathVariable Long id, Model model){
        Riku riku = rikuService.findOne(id);
        model.addAttribute("riku",riku);
        return "riku/bad";
    }

}
