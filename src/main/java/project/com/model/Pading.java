package project.com.model;

import java.util.List;

public class Pading<T> {
	private int total;
	private int indexPage;
	private int limit;
	
	public int getStartIndex() {
		return (indexPage - 1) * limit;
	}

	public Pading(int limit, int indexPage) {
		this.limit = limit;
		this.indexPage = indexPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(List<T> list) {
		this.total = list.size();
	}

	public int getTotalPage() {
		if((getTotal() % limit) != 0) {
			return (getTotal() / limit) + 1;
		}else {
			return getTotal() / limit;
		}
	}

	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
