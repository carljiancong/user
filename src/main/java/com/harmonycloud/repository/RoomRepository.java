package com.harmonycloud.repository;

import com.harmonycloud.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findByClinicId(Integer clinicId);

    @Query(nativeQuery = true,value = "select \"room\".* from \"room\",\"room_encounter_type\",\"encounter_type\"\n" +
            "where \"room\".\"room_id\"=\"room_encounter_type\".\"room_id\" and \"encounter_type\".\"encounter_type_id\"=\"room_encounter_type\".\"encounter_type_id\"\n" +
            "and \"clinic_id\"=?1 and \"encounter_type\".\"encounter_type_id\"=?2")
    List<Room> listRoom(Integer clinicId,Integer encounterTypeId);
}
