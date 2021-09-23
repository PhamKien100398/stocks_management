package project.com.dao;

import java.util.List;

import project.com.model.History;
import project.com.model.Pading;
import project.com.model.ProductInStock;

public interface HistoryDao extends GeneralDao<History>{
	List<ProductInStock> findProductInStocks(Pading<ProductInStock> pa, ProductInStock productInStock, String...strings);
}
