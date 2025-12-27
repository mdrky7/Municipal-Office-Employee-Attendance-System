package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.AttendanceLog;

import com.examly.springapp.service.AttendanceLogService;

@RequestMapping("/attendancelogs")
@RestController
public class AttendanceLogController {
    private AttendanceLogService service;

    public AttendanceLogController(AttendanceLogService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<AttendanceLog> createAttendanceLog(@RequestBody AttendanceLog attendanceLog){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAttendanceLog(attendanceLog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendanceLog> updateAttendanceLogById(@PathVariable Long id, @RequestBody AttendanceLog attendanceLog){
        return ResponseEntity.status(HttpStatus.OK).body(service.createAttendanceLog(attendanceLog));
    }

    @GetMapping
    public ResponseEntity<List<AttendanceLog>> getAllAttendanceLog(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllAttendanceLog());
    }
}
