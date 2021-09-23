package project.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.com.dao.MenuDao;
import project.com.model.Menu;
import project.com.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> findMenus(Object... objects) {
		// TODO Auto-generated method stub
		return menuDao.findMenus(objects);
	}

}
