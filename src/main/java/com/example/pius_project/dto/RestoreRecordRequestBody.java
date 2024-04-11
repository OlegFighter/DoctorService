package com.example.pius_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestoreRecordRequestBody implements Serializable {
    Long doctorId;
    String doctorFIO;
    Long recordId;
    String organization;
    String specialization;
    LocalDateTime time;
}
