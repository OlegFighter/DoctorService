package com.example.pius_project.repository;

import com.example.pius_project.dto.RecordView;
import com.example.pius_project.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query(value = "select r.* from pius.record r " +
            " where r.doctor_id =:doctorId and " +
            "cast(r.time as date) = (select dateadd('day', :page, min(cast(rr.time as date))) from pius.record rr " +
            " where rr.doctor_id =:doctorId)",nativeQuery = true)
    ArrayList<Record> findByDate(long doctorId, int page);
}