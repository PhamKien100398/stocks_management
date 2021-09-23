package project.com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.com.model.Menu;

public class MenuMapper implements RowMapper<Menu>{

	@Override
	public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		menu.setId(rs.getInt("ID"));
		menu.setOrder_index(rs.getInt("ORDER_INDEX"));
		menu.setParent_id(rs.getInt("PARENT_ID"));
		menu.setUrl(rs.getString("URL"));
		menu.setName(rs.getString("NAME"));
		menu.setActive_flag(rs.getInt("ACTIVE_FLAG"));
		menu.setCreate_date(rs.getDate("CREATE_DATE"));
		menu.setUpdate_date(rs.getDate("UPDATE_DATE"));
		return menu;
	}
	
}
