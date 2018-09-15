package wedding.entity;

import java.util.List;

/**
 * 封装分页数据的类
 * @author Tinmen
 *
 */
public class Page<T> {
	
	//每页数量
	public static final int PAGE_SIZE = 10;
	//分页数据集合
	private List<T> data;
	//总页数
	private int pageCount;
	//当前页数
	private int currentPage;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
