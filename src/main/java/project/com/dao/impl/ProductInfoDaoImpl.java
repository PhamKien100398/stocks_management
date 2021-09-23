package project.com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Controller;

import project.com.dao.ProductInfoDao;
import project.com.mapper.ProductMapper;
import project.com.model.ProductInfo;
import project.com.utils.SqlUtils;

@Controller
public class ProductInfoDaoImpl extends GeneralDaoImpl<ProductInfo> implements ProductInfoDao{

	@Override
	public List<ProductInfo> findAll() {
		// TODO Auto-generated method stub
		return getAll(SqlUtils.sqlFindByProperty("product_info"), new ProductMapper());
	}

	@Override
	public List<ProductInfo> findProductInfoByCode(Object... objects) {
		// TODO Auto-generated method stub
		return findByProperty(SqlUtils.sqlFindByProperty("product_info", "code"), new ProductMapper(), objects);
	}

	@Override
	public boolean save(int id, Object... objects) {
		// TODO Auto-generated method stub
		return save(SqlUtils.sqlInsert(id, "product_info"), objects);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return delete(SqlUtils.sqlDelete("product_info"), id);
	}

	@Override
	public List<ProductInfo> findProductInfoById(Object... objects) {
		// TODO Auto-generated method stub
		return findByProperty(SqlUtils.sqlFindByProperty("product_info", "id"), new ProductMapper(), objects);
	}

}
