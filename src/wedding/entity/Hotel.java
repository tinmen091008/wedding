package wedding.entity;

public class Hotel {
	private int hotel_id;
	private String hotel_name;
	private String hotel_address;
	private String hotel_star;
	private String hotel_img;
	public Hotel(int hotel_id, String hotel_name, String hotel_address,
			String hotel_star, String hotel_img) {
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		this.hotel_star = hotel_star;
		this.hotel_img = hotel_img;
	}

	public Hotel() {
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String gethotel_address() {
		return hotel_address;
	}
	public void sethotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}
	public String getHotel_star() {
		return hotel_star;
	}
	public void setHotel_star(String hotel_star) {
		this.hotel_star = hotel_star;
	}
	public String getHotel_img() {
		return hotel_img;
	}
	public void setHotel_img(String hotel_img) {
		this.hotel_img = hotel_img;
	}
	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name
				+ ", hotel_address=" + hotel_address + ", hotel_star=" + hotel_star
				+ ", hotel_img=" + hotel_img + "]";
	}
}
