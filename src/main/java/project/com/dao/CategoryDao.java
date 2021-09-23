package project.com.dao;

import java.util.List;

import project.com.model.Category;

public interface CategoryDao extends GeneralDao<Category>{
	boolean deleteCategory(int id);
	List<Category> findCategory(String s,Object...objects);
	boolean save(int id, Object...objects);
	List<Category> findAll();
}
