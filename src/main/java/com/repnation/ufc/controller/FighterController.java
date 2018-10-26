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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;

import static java.util.stream.Collectors.toList;

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
            @ApiResponse(code = 200, message = "Successfully retrieved the fighters"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")
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
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 404, message = "Accessing the resource you were trying to reach is forbidden")
    })
    @GetMapping(value = "/{id}", produces = "application/vnd.api+json")
    public FighterVo getFighterById(@PathVariable Long id) throws Exception{
        Fighter fighter = fighterService.findById(id);
        return FighterMapper.mapFromDomainToVo(fighter);
    }

    @ApiOperation(value = "Saves a new fighter")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "The resource sent was accepted")
    })
    @PostMapping(consumes = "application/vnd.api+json",
                 produces = "application/vnd.api+json")
    public Fighter saveFighter(@RequestBody FighterVo requestBody) {
        Fighter fighter = FighterMapper.mapFromVoToDomain(requestBody);
        return fighterService.save(fighter);
    }

}
