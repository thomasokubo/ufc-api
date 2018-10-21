package com.repnation.ufc.controller;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.domain.model.vo.FighterVo;
import com.repnation.ufc.service.FighterService;
import com.repnation.ufc.service.mapper.FighterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/fighters")
public class FighterController {


    private FighterService fighterService;

    @Autowired
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @GetMapping
    public List<FighterVo> getFighters() {
        return fighterService.findAll()
                .stream()
                .map(FighterMapper::mapFromDomainToVo)
                .collect(toList());
    }

    @GetMapping(value = "/{id}")
    public FighterVo getFighterById(@PathVariable Long id) throws Exception{
        Fighter fighter = fighterService.findById(id);
        return FighterMapper.mapFromDomainToVo(fighter);
    }
}
