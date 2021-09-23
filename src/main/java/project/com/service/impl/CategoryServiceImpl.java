package project.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.com.dao.CategoryDao;
import project.com.model.Category;
import project.com.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return categoryDao.deleteCategory(id);
	}

	@Override
	public Category findCategory(String s, Object...objects) {
		// TODO Auto-generated method stub
		List<Category> cates = categoryDao.findCategory(s, objects);
		return cates.size() > 0 ? cates.get(0) : null;
	}

	@Override
	public boolean save(int id, Object... objects) {
		// TODO Auto-generated method stub
		return categoryDao.save(id, objects);
	}

	@Override
	public List<Category> findList(String s, Object... objects) {
		// TODO Auto-generated method stub
		return categoryDao.findCategory(s, objects);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

}
