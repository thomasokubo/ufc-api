package com.repnation.ufc.service;

import com.repnation.ufc.domain.model.Fighter;
import com.repnation.ufc.exception.NotFoundException;
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

    public Fighter findById(Long id) throws RuntimeException {
        return fighterRepository.findById(id).orElseThrow(() -> new NotFoundException("Fighter", id));
    }

    public void delete(Long id) throws RuntimeException {
        Fighter fighter = fighterRepository.findById(id).orElseThrow(() -> new NotFoundException("Fighter", id));
        fighterRepository.delete(fighter);
    }

    public Fighter save(Fighter fighter) {
        return fighterRepository.save(fighter);
    }

    public List<Fighter> saveAll(List<Fighter> fighters) {
        return fighterRepository.saveAll(fighters);
    }
}
