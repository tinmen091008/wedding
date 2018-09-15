package wedding.entity;

public class Order {
	private int order_id;
	private String order_num;
	private int user_id;
	private String order_time;
	private String order_name;
	private String order_type;
	private String order_place;
	private String order_price;
	private String order_count;
	private String order_img;
	private String order_hotelname;
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_num=" + order_num
				+ ", user_id=" + user_id + ", order_time=" + order_time
				+ ", order_name=" + order_name + ", order_type=" + order_type
				+ ", order_place=" + order_place + ", order_price="
				+ order_price + ", order_count=" + order_count + ", order_img="
				+ order_img + ", order_hotelname=" + order_hotelname + "]";
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public String getOrder_place() {
		return order_place;
	}
	public void setOrder_place(String order_place) {
		this.order_place = order_place;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	public String getOrder_count() {
		return order_count;
	}
	public void setOrder_count(String order_count) {
		this.order_count = order_count;
	}
	public String getOrder_img() {
		return order_img;
	}
	public void setOrder_img(String order_img) {
		this.order_img = order_img;
	}
	public String getOrder_hotelname() {
		return order_hotelname;
	}
	public void setOrder_hotelname(String order_hotelname) {
		this.order_hotelname = order_hotelname;
	}
	
}
