package com.repnation.ufc.controller;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.domain.model.vo.FighterVo;
import com.repnation.ufc.service.FighterService;
import com.repnation.ufc.service.mapper.FighterMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

// Comments
@Api(value = "ufc-api", description = "Operations related to the fighters")
@RestController
@RequestMapping("/fighters")
public class FighterController {


    private FighterService fighterService;

    @Autowired
    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @ApiOperation(value = "Retrieves a list with all fighters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the fighters")
    })
    @GetMapping(produces = "application/vnd.api+json")
    public List<FighterVo> getFighters() {
        return fighterService.findAll()
                .stream()
                .map(FighterMapper::mapFromDomainToVo)
                .collect(toList());
    }

    @ApiOperation(value = "Retrieves the information of the fighter with the given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the fighter"),
            @ApiResponse(code = 404, message = "Accessing the resource you were trying to reach is forbidden")
    })
    @GetMapping(value = "/{id}", produces = "application/vnd.api+json")
    public FighterVo getFighterById(@PathVariable Long id) throws RuntimeException {
        Fighter fighter = fighterService.findById(id);
        return FighterMapper.mapFromDomainToVo(fighter);
    }

    @ApiOperation(value = "Saves a new fighter")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The resource sent was accepted")
    })
    @PostMapping(consumes = "application/vnd.api+json",
                 produces = "application/vnd.api+json")
    public FighterVo saveFighter(@RequestBody FighterVo requestBody) {
        Fighter fighter = FighterMapper.mapFromVoToDomain(requestBody);
        fighter = fighterService.save(fighter);
        return FighterMapper.mapFromDomainToVo(fighter);
    }

    @ApiOperation(value = "Updates the properties of the fighter with the given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated the fighter"),
            @ApiResponse(code = 404, message = "Accessing the resource you were trying to reach is forbidden")
    })
    @PatchMapping( value = "/{id}",
            consumes = "application/vnd.api+json",
            produces = "application/vnd.api+json")
    public FighterVo updateFighter(@PathVariable Long id, @RequestBody FighterVo fighterVo) throws RuntimeException {
        Fighter fighter = fighterService.findById(id);
        Optional.ofNullable(fighterVo.getFirstName()).ifPresent(fighter::setFirstName);
        Optional.ofNullable(fighterVo.getLastName()).ifPresent(fighter::setLastName);
        Optional.ofNullable(fighterVo.getNickname()).ifPresent(fighter::setNickname);
        Optional.ofNullable(fighterVo.getWeightClass()).ifPresent(fighter::setWeightClass);
        Optional.ofNullable(fighterVo.isTitleHolder()).ifPresent(fighter::setHoldsTitle);
        Optional.ofNullable(fighterVo.getAge()).ifPresent(fighter::setAge);
        Optional.ofNullable(fighterVo.getWinnings()).ifPresent(fighter::setWinnings);
        Optional.ofNullable(fighterVo.getLosses()).ifPresent(fighter::setLosses);
        Optional.ofNullable(fighterVo.getDraws()).ifPresent(fighter::setDraws);
        Optional.ofNullable(fighterVo.getHeight()).ifPresent(fighter::setHeight);
        Optional.ofNullable(fighterVo.getWeight()).ifPresent(fighter::setWeight);
        Optional.ofNullable(fighterVo.getSummary()).ifPresent(fighter::setSummary);
        fighter = fighterService.save(fighter);
        return FighterMapper.mapFromDomainToVo(fighter);
    }

    @ApiOperation(value = "Deletes the fighter with the given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted the fighter"),
            @ApiResponse(code = 404, message = "Accessing the resource you were trying to reach is forbidden")
    })
    @DeleteMapping(value = "/{id}", consumes = "application/vnd.api+json")
    public void deleteFighter(@PathVariable Long id) throws RuntimeException {
        fighterService.delete(id);
    }
}
