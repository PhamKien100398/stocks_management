package project.com.mapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import project.com.model.Users;

public class UserCallback implements PreparedStatementCallback<Users>{
	
	private Users users;
	
	public UserCallback(Users users) {
		this.users = users;
	}

	@Override
	public Users doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		ps.setString(1, users.getUser_name());
		ps.setString(2, users.getPassword());
		ps.setString(3, users.getEmail());
		ps.setString(4, users.getName());
		ps.setInt(5, users.getActive_flag());
		ps.setDate(6, users.getCreate_date());
		ps.setDate(7, users.getUpdate_date());
		return ps.execute() ? users : null;
	}

}
