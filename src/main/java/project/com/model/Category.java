package project.com.model;

import java.util.Date;

public class Category {
	private int id;
	private String code;
	private String name;
	private String description;
	private int active_flag; 
	private Date create_date; 
	private Date update_date;
	public Category() {
		super();
	}
	public Category(int id, String code, String name, String description, int active_flag, Date create_date,
			Date update_date) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.active_flag = active_flag;
		this.create_date = create_date;
		this.update_date = update_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getActive_flag() {
		return active_flag;
	}
	public void setActive_flag(int active_flag) {
		this.active_flag = active_flag;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
	
}
