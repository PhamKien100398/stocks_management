package project.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.com.dao.UserDao;
import project.com.model.Users;
import project.com.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public Users findUser(Object...object) {
		// TODO Auto-generated method stub
		List<Users> users = userDao.findUsers(object);
		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public boolean save(Users users) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users update(Users users) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
