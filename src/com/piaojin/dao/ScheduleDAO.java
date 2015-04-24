package com.piaojin.dao;

import com.piaojin.domain.Schedule;

/**
 * Created by yangjb on 2015/1/25.
 */
public interface ScheduleDAO extends BaseDAO<Schedule>{
	void deleteSchedule(Schedule schedule);
	Schedule findSchedule(String title);
	Schedule getById(int sid);
	void save(Schedule schedule);
	void update(Schedule schedule);
}
