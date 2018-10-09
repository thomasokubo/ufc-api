package com.repnation.ufc.service;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {

    private final FighterRepository fighterRepository;

    @Autowired
    public FighterService(FighterRepository fighterRepository) {
        this.fighterRepository = fighterRepository;
    }

    public List<Fighter> findAll() {
        return fighterRepository.findAll();
    }
}
