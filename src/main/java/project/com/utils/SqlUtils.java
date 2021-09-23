package project.com.utils;

import project.com.model.Pading;
import project.com.model.ProductInStock;

public class SqlUtils {
	
	public static final String sqlRoleJoinUsers = "select role.ID, role.ROLE_NAME, role.DESCRIPTION, role.ACTIVE_FLAG, role.CREATE_DATE,"
			+ "role.UPDATE_DATE from users inner join user_role on users.ID = user_role.USER_ID " + 
			"inner join role on role.ID = user_role.ROLE_ID where users.id = ?";
	
	public static final String sqlRoleJoinMenu = "select menu.ID, menu.NAME, menu.URL, menu.PARENT_ID, menu.ORDER_INDEX, "
			+ "menu.ACTIVE_FLAG, menu.CREATE_DATE, menu.UPDATE_DATE "
			+ "from role inner join auth on role.ID = auth.ROLE_ID " 
			+ "inner join menu on auth.MENU_ID = menu.ID where role.ID = ?";
	
	public static String sqlFindByProperty(String str,String...args) {
		StringBuilder sql = new StringBuilder("select * from "+str);
		if(args.length > 0) {
			sql.append(" where ");
			for(int i = 0; i < args.length; i++) {
				if(i == args.length - 1) {
					if(args[i].equals("email")) {
						sql.append("email = ?");
					}else if(args[i].equals("user_name")) {
						sql.append("user_name = ?");
					}else if(args[i].equals("id")) {
						sql.append("id = ?");
					}else if(args[i].equals("code")) {
						sql.append("code = ?");
					}
				}else {
					if(args[i].equals("email")) {
						sql.append("email = ? and ");
					}else if(args[i].equals("user_name")) {
						sql.append("user_name = ? and ");
					}else if(args[i].equals("id")) {
						sql.append("id = ? and ");
					}else if(args[i].equals("code")) {
						sql.append("code = ? and ");
					}
				}
			}
		}
		return sql.toString();
	}
	
	public static String sqlDelete(String str) {
		StringBuilder s = new StringBuilder("DELETE FROM "+str);
		s.append(" where id = ?");
		return s.toString();
	}
	
	public static String sqlInsert(int id, String value) {
		StringBuilder str = new StringBuilder("");
		if(id == 0) {
			str.append("insert into "+value+"(name, code, description, active_flag, create_date, update_date");
			if(value.equals("category")) {
				str.append(") values (?,?,?,?,?,?)");
			}else if(value.equals("product_info")) {
				str.append(", cate_id, img_url) values (?,?,?,?,?,?,?,?)");
			}
		}else {
			str.append("update category set name = ?, code = ?, description = ?, active_flag = ?, create_date = ?, update_date = ?");
			if(value.equals("category")) {
				str.append(" where id = ?");
			}else if(value.equals("product_info")) {
				str.append(", cate_id = ?, img_url = ? where id = ?");
			}
		}
		return str.toString();
	}
	
	public static String sqlPagination(Pading<ProductInStock> pa,ProductInStock productInStock ,String...strings) {
		StringBuilder str = new StringBuilder("");
		str.append("select category.NAME as CATE_NAME, product_info.CODE, product_info.NAME as PRO_NAME, product_info.IMG_URL, product_in_stock.QTY, product_in_stock.PRICE, product_in_stock.ID ");
		str.append("from product_in_stock inner join product_info on product_in_stock.PRODUCT_ID = product_info.ID ");
		str.append("inner join category on category.ID = product_info.CATE_ID");
		if(strings.length > 0) {
			str.append(" where ");
			for(int i = 0; i < strings.length; i++) {
				if(strings[i].equals("product_info.CODE")) {
					str.append("LOWER(product_info.CODE) like LOWER('%"+productInStock.getProductInfo().getCode()+"%')");
				}else if(strings[i].equals("category.NAME")) {
					str.append("LOWER(category.NAME) like LOWER('%"+productInStock.getProductInfo().getCategory().getName()+"%')");
				}else if(strings[i].equals("product_info.NAME")) {
					str.append("LOWER(product_info.NAME) like LOWER('%"+productInStock.getProductInfo().getName()+"%')");
				}
			}
		}
		str.append(" limit "+pa.getStartIndex()+","+pa.getLimit());
		return str.toString();
	}
}
