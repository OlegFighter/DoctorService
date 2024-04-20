package com.example.pius_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.pius_project.entity.Record;

import java.time.LocalDateTime;
import java.util.Comparator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordView {
    long id;
    LocalDateTime time;

    public RecordView(LocalDateTime time) {
        this.time = time;
    }

    public RecordView(Record record) {
        this.id = record.getId();
        this.time = record.getTime();
    }

    public static final Comparator<RecordView> COMPARE_BY_TIME = new Comparator<RecordView>() {
        @Override
        public int compare(RecordView o1, RecordView o2) {
            return o1.getTime().compareTo(o2.getTime());
        }
    };
}
