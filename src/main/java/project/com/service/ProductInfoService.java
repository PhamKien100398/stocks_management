package project.com.service;

import java.util.List;

import project.com.model.ProductInfo;

public interface ProductInfoService {
	List<ProductInfo> findAll();
	ProductInfo findProductInfoByCode(Object...objects);
	ProductInfo findProductInfoById(Object...objects);
	boolean save(ProductInfo productInfo);
	boolean delete(int id);
}
