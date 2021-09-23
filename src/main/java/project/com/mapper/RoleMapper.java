package project.com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.com.model.Role;

public class RoleMapper implements RowMapper<Role>{

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setId(rs.getInt("ID"));
		role.setRole_name(rs.getString("ROLE_NAME"));
		role.setDescription(rs.getString("DESCRIPTION"));
		role.setActive_flag(rs.getInt("ACTIVE_FLAG"));
		role.setCreate_date(rs.getDate("CREATE_DATE"));
		role.setUpdate_date(rs.getDate("UPDATE_DATE"));
		return role;
	}

}
