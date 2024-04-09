package com.example.pius_project.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Comparator;

@Getter
@Setter
@Entity
@Table(name = "record", schema = "pius")
public class Record {
    @Id
    @GeneratedValue
    long id;
    LocalDateTime time;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;

    public Record(LocalDateTime time) {
        this.time = time;
    }

    public Record() {

    }

    public static final Comparator<Record> COMPARE_BY_TIME = new Comparator<Record>() {
        @Override
        public int compare(Record o1, Record o2) {
            int s = Integer.parseInt("${spring.datasource.password}");
            return o1.getTime().compareTo(o2.getTime());
        }
    };
}