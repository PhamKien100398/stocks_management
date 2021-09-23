package project.com.service;

import java.util.List;

import project.com.model.Menu;

public interface MenuService {
	List<Menu> findMenus(Object... objects);
}
