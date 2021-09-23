package project.com.dao;

import java.util.List;

import project.com.model.ProductInfo;

public interface ProductInfoDao extends GeneralDao<ProductInfo>{
	List<ProductInfo> findAll();
	List<ProductInfo> findProductInfoByCode(Object...objects);
	List<ProductInfo> findProductInfoById(Object...objects);
	boolean save(int id, Object...objects);
	boolean delete(int id);
}
