package project.com.service;

import java.util.List;

import project.com.model.Role;

public interface RoleService {
	List<Role> findRoles(Object...objects);
}
