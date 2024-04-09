package com.example.pius_project.repository;

import com.example.pius_project.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query(value = "select r.* from record r " +
            "inner join doctor_records dr on r.id = dr.records_id where dr.doctor_id =:doctorId and " +
            "date(r.time) = (select min(date(r.time)) + interval '1 day'*:page from record r " +
            "inner join doctor_records dr on r.id = dr.records_id where dr.doctor_id =:doctorId)",nativeQuery = true)
    ArrayList<Record> findByDate(@Param("doctorId") long doctorId, @Param("page") int page);
}