package project.com.model;

import java.sql.Timestamp;
import java.util.Date;

public class UserRole {
	private	int id;
	private int role_id; 
	private int user_id;
	private int active_flag;
	private Date create_date; 
	private Date update_date;
	private Users users;
	private Role role;
	public UserRole() {
		super();
	}
	public UserRole(int id, int role_id, int user_id, int active_flag, Timestamp create_date, Timestamp update_date) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.user_id = user_id;
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
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
