package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.AttendanceLog;

public interface AttendanceLogServiceImpl {
    public AttendanceLog createAttendanceLog(AttendanceLog attendanceLog);
    public AttendanceLog updateAttendanceLogById(Long id, AttendanceLog attendanceLog);
    public List<AttendanceLog> getAllAttendanceLog();
}
