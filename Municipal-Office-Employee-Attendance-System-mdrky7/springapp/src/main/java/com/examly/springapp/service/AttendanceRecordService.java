package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.AttendanceRecord;
import com.examly.springapp.repository.AttendanceRecordRepository;

@Service
public class AttendanceRecordService {
    private final AttendanceRecordRepository repo;

    public AttendanceRecordService(AttendanceRecordRepository repo){
        this.repo = repo;
    }

    public AttendanceRecord addAttendanceRecord(AttendanceRecord attendanceRecord){
        return repo.save(attendanceRecord);
    }

    public List<AttendanceRecord> getAllAttendanceRecord(){
        List<AttendanceRecord> lar = repo.findAll();
        if(lar.isEmpty()){
            throw new ResourceNotFoundException("No attendance records found.");
        }
        return lar;
    }
}
