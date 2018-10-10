package com.repnation.ufc.controller;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fighters")
public class FighterController {


    private FighterService fighterService;

    @Autowired
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping
    public List<Fighter> getFighters() {
        return fighterService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Fighter getFighterById(@PathVariable Long id) throws Exception{
        return fighterService.findById(id);
    }
}
