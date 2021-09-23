package project.com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.com.dao.UserDao;
import project.com.mapper.UserCallback;
import project.com.mapper.UserMapper;
import project.com.model.Users;
import project.com.utils.SqlUtils;

@Repository
public class UserDaoImpl extends GeneralDaoImpl<Users> implements UserDao{

	@Override
	public boolean save(Users users) {
		// TODO Auto-generated method stub
		String sql = "insert into users(USER_NAME, PASSWORD, EMAIL,NAME,ACTIVE_FLAG, CREATE_DATE, UPDATE_DATE) value (?,?,?,?,?,?,?)";
		return save(sql, users.getUser_name(), users.getPassword(), users.getEmail(), users.getEmail(), users.getActive_flag(), users.getCreate_date(), users.getUpdate_date());
	}

	@Override
	public Users update(Users users) {
		// TODO Auto-generated method stub
		String sql = "update users set USER_NAME = ?, "
				+ "PASSWORD = ?, EMAIL = ?, NAME = ?, "
				+ "ACTIVE_FLAG = ?, CREATE_DATE = ?, UPDATE_DATE = ? where id = ?";
		return update(sql, new UserCallback(users));
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return getAll(SqlUtils.sqlFindByProperty("users"), new UserMapper());
	}

	@Override
	public List<Users> findUsers(Object...objects) {
		// TODO Auto-generated method stub
		return findByProperty(SqlUtils.sqlFindByProperty("users","email"), new UserMapper(), objects);
	}


}
