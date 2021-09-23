package project.com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.com.model.Category;
import project.com.model.ProductInStock;
import project.com.model.ProductInfo;

public class ProductInStockMapper implements RowMapper<ProductInStock>{

	@Override
	public ProductInStock mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProductInStock productInStock = new ProductInStock();
		ProductInfo productInfo = new ProductInfo();
		Category category = new Category();
		productInfo.setCode(rs.getString("CODE"));
		productInfo.setName(rs.getString("PRO_NAME"));
		category.setName(rs.getString("CATE_NAME"));
		productInfo.setCategory(category);
		productInfo.setImgUrl(rs.getString("IMG_URL"));
		productInStock.setProductInfo(productInfo);
		productInStock.setQty(rs.getInt("QTY"));
		productInStock.setPrice(rs.getBigDecimal("PRICE"));
		productInStock.setId(rs.getInt("ID"));
		return productInStock;
	}

}
