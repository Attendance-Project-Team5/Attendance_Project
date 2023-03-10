package com.team5.myapp.attendance.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team5.myapp.attendance.model.Attendance;
import com.team5.myapp.member.model.Member;

public interface IAttendanceService {
	//출석 insert
	void insertWorktime(String userId);
	void updateWorktime(String userId);
	
	//출결 가져오기
	Attendance selectAttendance(String userId);
	
	//출결 상태 update
	void updateAttendanceStatus(int attendanceStatus,String userId);
	
	//출결 현황 목록
	int selectTotalAttendancePage(String userId);
	List<Attendance> selectAttendanceList(String userId, int page);
	List<Attendance> selectCalendarList(String userId);

	//지각 횟수
	int selectLateCount(String userId);
	//조퇴 횟수
	int selectLeaveCount(String userId);
	//결근 횟수
	int selectAbsenceCount(String userId);
	//출석 횟수
	int selectAttendanceCount(String userId);
	
	//출퇴근 값이 null일 경우 status 1(결근으로 수정)
	void noCheckAttendance(String userId);
	void noAllCheckAttendance();
	//무단결근
	List<Attendance> selectMember();
	void noInsertAttendance(String userId);
}
