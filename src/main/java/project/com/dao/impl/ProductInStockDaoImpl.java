package project.com.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import project.com.dao.ProductInStockDao;
import project.com.mapper.ProductInStockMapper;
import project.com.model.Pading;
import project.com.model.ProductInStock;
import project.com.utils.SqlUtils;

@Repository
public class ProductInStockDaoImpl extends GeneralDaoImpl<ProductInStock> implements ProductInStockDao{

	@Override
	public List<ProductInStock> findProductInStocks(Pading<ProductInStock> pa, ProductInStock productInStock, String...strings) {
		// TODO Auto-generated method stub
		List<ProductInStock> list = findByProperty(SqlUtils.sqlPagination(pa, productInStock, strings), new ProductInStockMapper());
		return list.size() > 0 ? list : null;
	}

}
