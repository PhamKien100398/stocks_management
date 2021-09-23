package project.com.dao;

import java.util.List;

import project.com.model.Pading;
import project.com.model.ProductInStock;

public interface ProductInStockDao extends GeneralDao<ProductInStock>{
	List<ProductInStock> findProductInStocks(Pading<ProductInStock> pa, ProductInStock productInStock, String...strings);
}
