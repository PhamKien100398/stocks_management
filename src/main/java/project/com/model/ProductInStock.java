package project.com.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductInStock {
	private int id;
	private ProductInfo productInfo;
	private int qty;
	private int activeFlag;
	private BigDecimal price;
	private Date createDate;
	private Date updateDate;
	public ProductInStock() {
		super();
	}
	public ProductInStock(Integer id, ProductInfo productInfo, int qty, int activeFlag, BigDecimal price,
			Date createDate, Date updateDate) {
		super();
		this.id = id;
		this.productInfo = productInfo;
		this.qty = qty;
		this.activeFlag = activeFlag;
		this.price = price;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ProductInfo getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
}
