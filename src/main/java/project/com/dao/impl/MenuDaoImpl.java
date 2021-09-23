package project.com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.com.dao.MenuDao;
import project.com.mapper.MenuMapper;
import project.com.model.Menu;
import project.com.utils.SqlUtils;

@Repository
public class MenuDaoImpl extends GeneralDaoImpl<Menu> implements MenuDao{

	@Override
	public List<Menu> findMenus(Object... objects) {
		// TODO Auto-generated method stub
		return findByProperty(SqlUtils.sqlRoleJoinMenu, new MenuMapper(), objects);
	}

}
