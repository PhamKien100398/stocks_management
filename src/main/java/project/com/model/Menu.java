package project.com.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu {
	private int id;
	private int parent_id;
	private String url;
	private String name;
	private int order_index;
	private int active_flag; 
	private Date create_date; 
	private Date update_date;
	private String id_menu;
	private List<Menu> listMenuChild = new ArrayList<Menu>();
	public Menu() {
		super();
	}
	public Menu(int id, int parent_id, String url, String name, int order_index, int active_flag, Timestamp create_date,
			Timestamp update_date) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.url = url;
		this.name = name;
		this.order_index = order_index;
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
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder_index() {
		return order_index;
	}
	public void setOrder_index(int order_index) {
		this.order_index = order_index;
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
	public String getId_menu() {
		return id_menu;
	}
	public void setId_menu(String id_menu) {
		this.id_menu = id_menu;
	}
	public List<Menu> getListMenuChild() {
		return listMenuChild;
	}
	public void setListMenuChild(List<Menu> listMenuChild) {
		this.listMenuChild = listMenuChild;
	}
	
	
}
