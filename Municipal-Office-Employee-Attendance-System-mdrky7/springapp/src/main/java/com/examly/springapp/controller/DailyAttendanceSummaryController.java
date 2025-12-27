package com.examly.springapp.controller;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.DailyAttendanceSummary;
import com.examly.springapp.service.DailyAttendanceSummaryService;

@RequestMapping("/daily-summary")
@RestController
public class DailyAttendanceSummaryController {
    private final DailyAttendanceSummaryService service;

    public DailyAttendanceSummaryController(DailyAttendanceSummaryService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<DailyAttendanceSummary> addDailyAttendanceSummary(@RequestBody DailyAttendanceSummary dailyAttendanceSummary){
        return ResponseEntity.status(HttpStatus.OK).body(service.createDailyAttendanceSummary(dailyAttendanceSummary));
    } 
    
    @GetMapping("/employee/{id}")
    public ResponseEntity<Page<DailyAttendanceSummary>> getSummaryByEmployeeCode(@PathVariable Long id, @RequestParam int page, @RequestParam int size){
        return ResponseEntity.status(HttpStatus.OK).body(service.getByEmployeeCode(id, page, size));
    }
    
    @GetMapping("/employee/code/{employeeCode}")
    public ResponseEntity<Page<DailyAttendanceSummary>> getSummaryByEmployeeCodeAndDateRange(@PathVariable String employeeCode, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @RequestParam int page, @RequestParam int size){
        return ResponseEntity.status(HttpStatus.OK).body(service.getByEmployeeCodeAndDateRange(employeeCode, startDate, endDate, page, size));
    }
}
