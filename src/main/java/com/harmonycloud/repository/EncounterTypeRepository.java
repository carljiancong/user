package com.harmonycloud.repository;

import com.harmonycloud.entity.EncounterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncounterTypeRepository extends JpaRepository<EncounterType, Integer> {

    @Query(nativeQuery = true,value = "select \"encounter_type\".* from \"encounter_type\",\"clinic_encounter_type\",\"clinic\"\n" +
            "where \"clinic\".\"clinic_id\" = \"clinic_encounter_type\".\"clinic_id\" and \"encounter_type\".\"encounter_type_id\"=\"clinic_encounter_type\".\"encounter_type_id\"\n" +
            "and \"clinic\".\"clinic_id\"=?1")
    List<EncounterType> findByClinicId(Integer clinicId);
}
