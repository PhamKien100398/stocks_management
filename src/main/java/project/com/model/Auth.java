package project.com.model;

import java.sql.Timestamp;
import java.util.Date;

public class Auth {
	private int id;
	private int role_id;
	private int menu_id;
	private int permission;
	private int active_flag; 
	private Date create_date; 
	private Date update_date;
	private Role role;
	public Auth() {
		super();
	}
	public Auth(int id, int role_id, int menu_id, int permission, int active_flag, Timestamp create_date,
			Timestamp update_date, Role role) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.menu_id = menu_id;
		this.permission = permission;
		this.active_flag = active_flag;
		this.create_date = create_date;
		this.update_date = update_date;
		this.role = role;
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
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
