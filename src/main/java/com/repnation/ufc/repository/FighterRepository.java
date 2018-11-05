package com.repnation.ufc.repository;

import com.repnation.ufc.domain.model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FighterRepository extends JpaRepository<Fighter, Long>{

}
