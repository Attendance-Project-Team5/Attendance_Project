package com.team5.myapp.attendance.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team5.myapp.attendance.dao.IAttendanceRepository;
import com.team5.myapp.attendance.model.Attendance;
import com.team5.myapp.attendance.service.IAttendanceService;

@Service
public class AttendanceService implements IAttendanceService {
	@Autowired
	IAttendanceRepository attendanceRepository;
	
	//출근
	@Override
	public void insertWorktime(String userId) {
		attendanceRepository.insertWorktime(userId);
	}
	//퇴근
	@Override
	public void updateWorktime(String userId){
		attendanceRepository.updateWorktime(userId);
	}
	
	//출결 가져오기
	@Transactional
	public Attendance selectAttendance(String userId) {
		return attendanceRepository.selectAttendance(userId);
	}
	
	//status 현황 변경
	@Transactional
	public void updateAttendanceStatus(int attendanceStatus, String userId) {
		Attendance attendance = new Attendance();
		attendance.setStatus(attendanceStatus);
		attendance.setUserId(userId);
		attendanceRepository.updateAttendanceStatus(attendance);
		
	}
	
	
	@Override
	public int selectTotalAttendancePage(String userId) {
		return attendanceRepository.selectTotalAttendancePage(userId);
	}
	
	//출결현황
	@Override
	public List<Attendance> selectAttendanceList(String userId, int page) {
		int start = (page-1)*5+1;
		return attendanceRepository.selectAttendanceList(userId, start, start+4);
	}
	@Override
	public List<Attendance> selectCalendarList(String userId) {
		return attendanceRepository.selectCalendarList(userId);
	}
	
	//지각
	@Override
	public int selectLateCount(String userId) {
		return attendanceRepository.selectLateCount(userId);
	}
	//결근
	@Override
	public int selectAbsenceCount(String usrId) {
		return attendanceRepository.selectAbsenceCount(usrId);
	}
	//출근
	@Override
	public int selectAttendanceCount(String userId) {
		return attendanceRepository.selectAttendanceCount(userId);
	}
	//조퇴
	@Override
	public int selectLeaveCount(String userId) {
		return attendanceRepository.selectLeaveCount(userId);
	}
	
	//출퇴근 값이 null일 경우 status 1(결근으로 수정)
	@Override
	public void noCheckAttendance(String userId) {
		attendanceRepository.noCheckAttendance(userId);
	}
	@Override
	public void noAllCheckAttendance() {
		attendanceRepository.noAllCheckAttendance();
	}
	//무단결근
	@Override
	public void noInsertAttendance(String userId) {
		
		attendanceRepository.noInsertAttendance(userId);
		
	}
	@Override
	public List<Attendance> selectMember() {
		return attendanceRepository.selectMember();
	}
	
}
