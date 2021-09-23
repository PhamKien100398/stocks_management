package project.com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.com.dao.CategoryDao;
import project.com.mapper.CategoryMapper;
import project.com.model.Category;
import project.com.utils.SqlUtils;

@Repository
public class CategoryDaoImpl extends GeneralDaoImpl<Category> implements CategoryDao{

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return delete(SqlUtils.sqlDelete("category"), id);
	}

	@Override
	public List<Category> findCategory(String s,Object... objects) {
		// TODO Auto-generated method stub
		return findByProperty(SqlUtils.sqlFindByProperty("category", s), new CategoryMapper(), objects);
	}

	@Override
	public boolean save(int id, Object... objects) {
		// TODO Auto-generated method stub
		return save(SqlUtils.sqlInsert(id, "category"), objects);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return getAll(SqlUtils.sqlFindByProperty("category"), new CategoryMapper());
	}

}
