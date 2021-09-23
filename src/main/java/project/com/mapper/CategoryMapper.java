package project.com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.com.model.Category;

public class CategoryMapper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setId(rs.getInt("ID"));
		category.setCode(rs.getString("CODE"));
		category.setName(rs.getString("NAME"));
		category.setDescription(rs.getString("DESCRIPTION"));
		category.setActive_flag(rs.getInt("ACTIVE_FLAG"));
		category.setCreate_date(rs.getDate("CREATE_DATE"));
		category.setUpdate_date(rs.getDate("UPDATE_DATE"));
		return category;
	}
	
}
