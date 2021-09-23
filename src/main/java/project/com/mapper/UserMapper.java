package project.com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.com.model.Users;

public class UserMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Users users = new Users();
		users.setId(rs.getInt("ID"));
		users.setUser_name(rs.getString("USER_NAME"));
		users.setEmail(rs.getString("EMAIL"));
		users.setPassword(rs.getString("PASSWORD"));
		users.setName(rs.getString("NAME"));
		users.setActive_flag(rs.getInt("ACTIVE_FLAG"));
		users.setCreate_date(rs.getDate("CREATE_DATE"));
		users.setUpdate_date(rs.getDate("UPDATE_DATE"));
		return users;
	}

}
