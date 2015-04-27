package com.piaojin.dao.impl;

import java.util.List;
import com.piaojin.domain.Schedule;


public class ScheduleDAOImpl extends BaseDAOImpl<Schedule> implements com.piaojin.dao.ScheduleDAO {

public void deleteSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		super.delete(schedule);
	}

	public Schedule findSchedule(String title) {
		// TODO Auto-generated method stub
		String hql="from Users where title='"+title;
		List list=super.find(hql, null);
		if(list.size()==1){
			Schedule schedule=(Schedule)list.get(0);
			schedule.setKid(schedule.getSid());
			return schedule;
		}else{
			return null;
		}
	}

	public Schedule getById(int sid) {
		// TODO Auto-generated method stub
		Schedule schedule=super.findById(Schedule.class, sid);
		schedule.setKid(schedule.getSid());
		return schedule;
	}
	
	public void save(Schedule schedule){
		super.save(schedule);
	}

	public void update(Schedule schedule) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(schedule);
	}
}
