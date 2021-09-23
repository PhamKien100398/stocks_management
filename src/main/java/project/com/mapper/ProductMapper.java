package project.com.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.com.model.ProductInfo;

public class ProductMapper implements RowMapper<ProductInfo>{

	@Override
	public ProductInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ProductInfo product = new ProductInfo();
		product.setId(rs.getInt("ID"));
		product.setCateId(rs.getInt("CATE_ID"));
		product.setCode(rs.getString("CODE"));
		product.setName(rs.getString("NAME"));
		product.setDescription(rs.getString("DESCRIPTION"));
		product.setImgUrl(rs.getString("IMG_URL"));
		product.setActive_flag(rs.getInt("ACTIVE_FLAG"));
		product.setCreate_date(rs.getDate("CREATE_DATE"));
		product.setUpdate_date(rs.getDate("UPDATE_DATE"));
		return product;
	}
	
}
