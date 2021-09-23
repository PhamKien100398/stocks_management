package project.com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.com.dao.RoleDao;
import project.com.mapper.RoleMapper;
import project.com.model.Role;
import project.com.utils.SqlUtils;

@Repository
public class RoleDaoImpl extends GeneralDaoImpl<Role> implements RoleDao{

	@Override
	public List<Role> findRoles(Object...objects) {
		// TODO Auto-generated method stub
		return findByProperty(SqlUtils.sqlRoleJoinUsers, new RoleMapper(), objects);
	}

}
