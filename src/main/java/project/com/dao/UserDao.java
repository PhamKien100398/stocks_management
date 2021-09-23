package project.com.dao;

import java.util.List;

import project.com.model.Users;

public interface UserDao extends GeneralDao<Users>{
	List<Users> getAll();
	List<Users> findUsers(Object...objects);
	boolean save(Users users);
	Users update(Users users);
	boolean delete(int id);
}
