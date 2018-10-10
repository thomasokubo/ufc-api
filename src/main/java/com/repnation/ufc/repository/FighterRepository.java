package com.repnation.ufc.repository;

import com.repnation.ufc.domain.model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FighterRepository extends JpaRepository<Fighter, Long>{

}
