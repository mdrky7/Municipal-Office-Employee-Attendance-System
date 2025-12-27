package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.AttendanceLog;
import com.examly.springapp.repository.AttendanceLogRepository;

@Service
public class AttendanceLogService implements AttendanceLogServiceImpl{
    private final AttendanceLogRepository repo;

    public AttendanceLogService(AttendanceLogRepository repo){
        this.repo = repo;
    }

    @Override
    public AttendanceLog createAttendanceLog(AttendanceLog attendanceLog){
        return repo.save(attendanceLog);
    }
    
    @Override
    public AttendanceLog updateAttendanceLogById(Long id, AttendanceLog attendanceLog){
        attendanceLog.setId(id);
        return repo.save(attendanceLog);
    }
    
    @Override
    public List<AttendanceLog> getAllAttendanceLog(){
        List<AttendanceLog> lal = repo.findAll();
        if(lal.isEmpty()){
            throw new ResourceNotFoundException("No attendance logs found");
        }

        return lal;
    }
}
