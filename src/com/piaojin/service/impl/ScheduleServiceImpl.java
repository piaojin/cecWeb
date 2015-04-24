package com.piaojin.service.impl;

import com.piaojin.dao.ScheduleDAO;
import com.piaojin.domain.Schedule;
import com.piaojin.service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {

	private ScheduleDAO scheduleDAO;
	public void deleteSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		scheduleDAO.deleteSchedule(schedule);
	}

	public ScheduleDAO getScheduleDAO() {
		return scheduleDAO;
	}

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

	public Schedule findSchedule(String title) {
		// TODO Auto-generated method stub
		return scheduleDAO.findSchedule(title);
	}

	public Schedule getById(int sid) {
		// TODO Auto-generated method stub
		return scheduleDAO.getById(sid);
	}

	public void save(Schedule schedule) {
		// TODO Auto-generated method stub
		scheduleDAO.save(schedule);
	}

	public void update(Schedule schedule) {
		// TODO Auto-generated method stub
		scheduleDAO.update(schedule);
	}

}
