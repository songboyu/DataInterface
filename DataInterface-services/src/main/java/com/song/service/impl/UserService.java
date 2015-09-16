package com.song.service.impl;


import com.song.model.User;
import com.song.service.IUserService;
import com.song.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public boolean createUser(User u)
	{
		return userDao.createUserDao(u);
	}

}
