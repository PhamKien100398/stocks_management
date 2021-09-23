package project.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.com.dao.RoleDao;
import project.com.model.Role;
import project.com.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> findRoles(Object...objects) {
		// TODO Auto-generated method stub
		return roleDao.findRoles(objects);
	}

}
