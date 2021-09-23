package project.com.service;

import java.util.List;

import project.com.model.Category;

public interface CategoryService {
	boolean deleteCategory(int id);
	Category findCategory(String s, Object...objects);
	boolean save(int id, Object...objects);
	List<Category> findList(String s, Object...objects);
	List<Category> findAll();
}
