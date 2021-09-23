package project.com.service;

import java.util.List;

import project.com.model.Users;

public interface UserService {
	List<Users> getAll();
	Users findUser(Object...objects);
	boolean save(Users users);
	Users update(Users users);
	boolean delete(int id);
}
