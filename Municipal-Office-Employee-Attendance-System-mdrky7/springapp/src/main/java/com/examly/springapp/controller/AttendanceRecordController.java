package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.AttendanceRecord;
import com.examly.springapp.service.AttendanceRecordService;

@RequestMapping("/attendance-records")
@RestController
public class AttendanceRecordController {
    private final AttendanceRecordService service;

    public AttendanceRecordController(AttendanceRecordService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AttendanceRecord> addAttendanceRecord(@RequestBody AttendanceRecord attendanceRecord){
        return ResponseEntity.status(HttpStatus.OK).body(service.addAttendanceRecord(attendanceRecord));
    }

    @GetMapping
    public ResponseEntity<List<AttendanceRecord>> getAllAttendanceRecord(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllAttendanceRecord());
    }
}
