package project.com.dao;

import java.util.List;

import project.com.model.Role;

public interface RoleDao extends GeneralDao<Role>{
	List<Role> findRoles(Object...objects);
}
