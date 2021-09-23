package project.com.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Role {
	private int id;
	private String role_name;
	private String description;
	private int active_flag; 
	private Date create_date; 
	private Date update_date;
	private List<UserRole> user_role = new ArrayList<UserRole>();
	public Role() {
		super();
	}
	public Role(int id, String role_name, String description, int active_flag, Timestamp create_date,
			Timestamp update_date, List<UserRole> user_role) {
		super();
		this.id = id;
		this.role_name = role_name;
		this.description = description;
		this.active_flag = active_flag;
		this.create_date = create_date;
		this.update_date = update_date;
		this.user_role = user_role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
	public List<UserRole> getUser_role() {
		return user_role;
	}
	public void setUser_role(List<UserRole> user_role) {
		this.user_role = user_role;
	}
	
	
}
