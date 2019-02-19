package com.harmonycloud.repository;

import com.harmonycloud.entity.EncounterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterTypeRepository extends JpaRepository<EncounterType,Integer> {
}
