package com.piaojin.service;

import com.piaojin.domain.Schedule;

public interface ScheduleService {
	void deleteSchedule(Schedule schedule);
	Schedule findSchedule(String title);
	Schedule getById(int sid);
	void save(Schedule schedule);
	void update(Schedule schedule);
}
