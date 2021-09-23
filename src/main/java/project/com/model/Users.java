package project.com.model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
	
	private int id; 
	private String user_name;
	private String email;
	private String password;
	private String name;
	private int active_flag; 
	private Date create_date; 
	private Date update_date;
	private List<UserRole> user_role = new ArrayList<UserRole>();
	private Map<Integer, List<Menu>> listMenu = new HashMap<Integer, List<Menu>>();
	private List<Menu> menus = new ArrayList<Menu>();
	
	public Users() {
		super();
	}

	public Users(int id, String user_name, String password, String email, String name, int active_flag,
			Date create_date, Date update_date) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.name = name;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Map<Integer, List<Menu>> getListMenu() {
		return listMenu;
	}

	public void setListMenu(Map<Integer, List<Menu>> listMenu) {
		this.listMenu = listMenu;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
