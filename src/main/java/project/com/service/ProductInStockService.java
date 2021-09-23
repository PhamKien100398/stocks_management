package project.com.service;

import java.util.List;

import project.com.model.Pading;
import project.com.model.ProductInStock;

public interface ProductInStockService {
	List<ProductInStock> findProductInStocks(Pading<ProductInStock> pa, ProductInStock productInStock);
}
