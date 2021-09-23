package project.com.dao;

import java.util.List;

import project.com.model.Menu;

public interface MenuDao extends GeneralDao<Menu>{
	List<Menu> findMenus(Object...objects);
}
