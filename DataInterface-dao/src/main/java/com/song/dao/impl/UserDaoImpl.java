package com.song.dao.impl;

import com.song.model.User;
import com.song.dao.IUserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UserDaoImpl  implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public boolean createUserDao(User user) {
			sessionFactory.getCurrentSession().save(user);
	
		
		return true;
	}

}
