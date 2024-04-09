package com.example.pius_project.service;

import com.example.pius_project.dto.CreateRecordRequestBody;
import com.example.pius_project.dto.GetAvailableRecordsRequestBody;
import com.example.pius_project.dto.GetAvailableRecordsResponseBody;
import com.example.pius_project.dto.RecordView;
import com.example.pius_project.entity.Doctor;
import com.example.pius_project.entity.Record;
import com.example.pius_project.notFoundExceptions.DoctorNotFoundException;
import com.example.pius_project.notFoundExceptions.RecordNotFoundException;
import com.example.pius_project.repository.DoctorRepository;
import com.example.pius_project.repository.RecordRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Set;

public class RecordService {

    private final RecordRepository recordRepository;
    private final DoctorRepository doctorRepository;

    public RecordService(RecordRepository recordRepository, DoctorRepository doctorRepository) {
        this.recordRepository = recordRepository;
        this.doctorRepository = doctorRepository;
    }

    public GetAvailableRecordsResponseBody getRecords(GetAvailableRecordsRequestBody
                                                                        getAvailableRecordsRequestBody){
        ArrayList<Record> records = recordRepository.findByDate(
                                                                getAvailableRecordsRequestBody.getDoctorId(),
                                                                getAvailableRecordsRequestBody.getIndexFrom()
                                                                );
        records.sort(Record.COMPARE_BY_TIME);
        Doctor doctor = doctorRepository.findById(getAvailableRecordsRequestBody.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException(getAvailableRecordsRequestBody.getDoctorId()));
        ArrayList<RecordView> recordViews = new ArrayList<>();
        for (Record record : records) {
            recordViews.add(new RecordView(record));
        }
        return new GetAvailableRecordsResponseBody(recordViews, doctor.getName(), doctor.getSpecialization(),
                doctor.getOrganization());
    }

    public void createRecord(CreateRecordRequestBody body){
        Record record;
        try{
            record = recordRepository.findById(body.getRecordId()).orElseThrow(() -> new RecordNotFoundException(body.getRecordId()));
        }
        catch (RecordNotFoundException e){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Such record doesn't exist!");
        }
        Doctor doctor = doctorRepository.findById(body.getDoctorId()).orElseThrow(() -> new DoctorNotFoundException(body.getDoctorId()));

        Set<Record> doctorRecords = doctor.getRecords();
        doctorRecords.remove(record);
        doctorRepository.save(doctor);
    }
}
