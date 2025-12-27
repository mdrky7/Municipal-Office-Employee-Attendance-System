package com.examly.springapp.service;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.DailyAttendanceSummary;
import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.DailyAttendanceSummaryRepository;
import com.examly.springapp.repository.EmployeeRepository;

@Service
public class DailyAttendanceSummaryService {
    private final DailyAttendanceSummaryRepository repo;
    private final EmployeeRepository erepo; 

    

    public DailyAttendanceSummaryService(DailyAttendanceSummaryRepository repo, EmployeeRepository erepo) {
        this.repo = repo;
        this.erepo = erepo;
    }

    public DailyAttendanceSummary createDailyAttendanceSummary(DailyAttendanceSummary dailyAttendanceSummary){
        return repo.save(dailyAttendanceSummary);
    }

    public Page<DailyAttendanceSummary> getByEmployeeCode(Long empId, int page, int size){
        Optional<Employee> empOpt = erepo.findById(empId);
        if(empOpt.isEmpty()){
            return Page.empty(PageRequest.of(page, size));
        }
        
        Employee emp = empOpt.get();
        String employeeCode = emp.getEmpCode();
        return repo.findByEmployeeCode(employeeCode,PageRequest.of(page, size));
    }

    public Page<DailyAttendanceSummary> getByEmployeeCodeAndDateRange(String employeeCode, LocalDate startDate, LocalDate endDate, int page, int size){
        return repo.findByEmployeeCodeAndDateBetween(employeeCode, startDate, endDate, PageRequest.of(page,size));
    }
}
