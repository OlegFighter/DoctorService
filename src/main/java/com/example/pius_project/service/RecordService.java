package com.example.pius_project.service;

import com.example.pius_project.dto.CreateRecordRequestBody;
import com.example.pius_project.dto.GetAvailableRecordsRequestBody;
import com.example.pius_project.dto.GetAvailableRecordsResponseBody;
import com.example.pius_project.dto.RecordView;
import com.example.pius_project.dto.RestoreRecordRequestBody;
import com.example.pius_project.dto.StoreRecordDto;
import com.example.pius_project.entity.Doctor;
import com.example.pius_project.entity.Record;
import com.example.pius_project.feign.StoreRecordClient;
import com.example.pius_project.notFoundExceptions.DoctorNotFoundException;
import com.example.pius_project.notFoundExceptions.RecordNotFoundException;
import com.example.pius_project.repository.DoctorRepository;
import com.example.pius_project.repository.RecordRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Set;

@Service
public class RecordService {

    private final RecordRepository recordRepository;
    private final DoctorRepository doctorRepository;
    private final StoreRecordClient storeRecordClient;

    public RecordService(RecordRepository recordRepository, DoctorRepository doctorRepository, StoreRecordClient storeRecordClient) {
        this.recordRepository = recordRepository;
        this.doctorRepository = doctorRepository;
        this.storeRecordClient = storeRecordClient;
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

    public void createRecord(CreateRecordRequestBody body, long userId){
        Record record;
        try{
            record = recordRepository.findById(body.getRecordId()).orElseThrow(() -> new RecordNotFoundException(body.getRecordId()));
        }
        catch (RecordNotFoundException e){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Such record doesn't exist!");
        }
        Doctor doctor = doctorRepository.findById(body.getDoctorId()).orElseThrow(() -> new DoctorNotFoundException(body.getDoctorId()));

        Set<Record> doctorRecords = doctor.getRecords();
        StoreRecordDto storeRecordDto = new StoreRecordDto(
                body.getRecordId(),
                body.getDoctorId(),
                doctor.getName(),
                record.getTime(),
                doctor.getSpecialization(),
                doctor.getOrganization());
        storeRecordClient.storeRecord(storeRecordDto, userId);
        doctorRecords.remove(record);
        doctorRepository.save(doctor);
    }

    public void restoreRecord(RestoreRecordRequestBody body){
        Record record = new Record(body.getTime());
        try{
            Doctor doctor = doctorRepository.findById(body.getDoctorId())
                    .orElseThrow(() -> new DoctorNotFoundException(body.getDoctorId()));
            Set<Record> recordSet = doctor.getRecords();
            recordSet.add(record);
            doctor.setRecords(recordSet);
            record.setDoctor(doctor);
            recordRepository.save(record);
            doctorRepository.save(doctor);
        } catch (DoctorNotFoundException e){
            doctorRepository.save(new Doctor(
                    body.getDoctorId(),
                    body.getDoctorFIO(),
                    body.getOrganization(),
                    body.getSpecialization(),
                    Set.of(record)));
            recordRepository.save(record);
        }
    }
}
