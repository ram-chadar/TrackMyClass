package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Attendance;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public String takeAttendance(Attendance attendance) {
		Session session = null;
		String msg = null;
		try {
			session = factory.openSession();
			session.save(attendance);
			session.beginTransaction().commit();
			msg = "Attendance Submited !";

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something went wrong during submit attendance";
		} finally {
			session.close();
		}
		return msg;
	}

}
