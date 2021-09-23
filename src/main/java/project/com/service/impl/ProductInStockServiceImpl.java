package project.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.com.dao.ProductInStockDao;
import project.com.model.Pading;
import project.com.model.ProductInStock;
import project.com.service.ProductInStockService;

@Service
public class ProductInStockServiceImpl implements ProductInStockService{
	
	@Autowired
	private ProductInStockDao productInStockDao;

	@Override
	public List<ProductInStock> findProductInStocks(Pading<ProductInStock> pa, ProductInStock productInStock) {
		// TODO Auto-generated method stub
		if(productInStock.getProductInfo() != null) {
			if(productInStock.getProductInfo().getCode() != null && !productInStock.getProductInfo().getCode().isEmpty()) {
				return productInStockDao.findProductInStocks(pa, productInStock, "product_info.CODE");
			}else if(productInStock.getProductInfo().getName() != null && !productInStock.getProductInfo().getName().isEmpty()) {
				return productInStockDao.findProductInStocks(pa, productInStock, "product_info.NAME");
			}else if(productInStock.getProductInfo().getCategory().getName() != null && !productInStock.getProductInfo().getCategory().getName().isEmpty()) {
				return productInStockDao.findProductInStocks(pa, productInStock, "category.NAME");
			}
		}else {
			return productInStockDao.findProductInStocks(pa, productInStock);
		}
		return null;
	}

}
