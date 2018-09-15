package wedding.dao.impl;

import java.util.List;

import wedding.DBUtils.DBUtils;
import wedding.dao.IHotelDAO;
import wedding.entity.Hotel;
import wedding.entity.HotelInfo;
import wedding.entity.PackageInfo;
import wedding.entity.Room;

/**
 * 酒店DAO的实现类
 * @author Tinmen
 *
 */
public class HotelDAOImpl implements IHotelDAO{
	
	@Override
	public void addHotel(Hotel hotel) {
		DBUtils.update("insert into tb_hotel (hotel_name, hotel_address, hotel_star, hotel_img) value(?,?,?,?)", 
				hotel.getHotel_name(),hotel.gethotel_address(),hotel.getHotel_star(),hotel.getHotel_img());
		
	}

	@Override
	public List<Hotel> selectAllHotels() {
		return DBUtils.queryList(Hotel.class, "select * from tb_hotel");
	}

	@Override
	public int selectCount() {
		return DBUtils.queryCount("select count(*) from tb_hotel");
	}

	@Override
	public List<Hotel> selectHotelsByPage(int pageNo, int pageSize) {
		return DBUtils.queryList(Hotel.class, "select * from tb_hotel limit ?,?", pageNo,pageSize);
	}

	@Override
	public HotelInfo selectHotelInfoById(int hotelId) {
		return DBUtils.query(HotelInfo.class, "select * from tb_hotelinfo where hotel_id = ?", hotelId);
	}

	@Override
	public List<Room> selectRoomsById(int hotelId) {
		return DBUtils.queryList(Room.class, "select * from tb_room where hotel_id = ?", hotelId);
	}

	@Override
	public List<PackageInfo> selectPackagesById(int hotelId) {
		return DBUtils.queryList(PackageInfo.class, "select * from tb_package where hotel_id = ?", hotelId);
	}
	
	@Override
	public Hotel selectHotelById(int hotelId) {
		return DBUtils.query(Hotel.class, "select * from tb_hotel where hotel_id = ?", hotelId);
	}



}
