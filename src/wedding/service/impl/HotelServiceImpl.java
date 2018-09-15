package wedding.service.impl;

import java.util.List;

import wedding.dao.IHotelDAO;
import wedding.dao.impl.HotelDAOImpl;
import wedding.entity.Hotel;
import wedding.entity.HotelInfo;
import wedding.entity.PackageInfo;
import wedding.entity.Page;
import wedding.entity.Room;
import wedding.service.IHotelService;

public class HotelServiceImpl implements IHotelService{

	private IHotelDAO hotelDAO = new HotelDAOImpl();
	
	@Override
	public List<Hotel> findAllHotels() {
		return hotelDAO.selectAllHotels();
	}

	@Override
	public Page<Hotel> findHotelsByPage(int pageNo, int pageSize) {
		//查询酒店总数
		int total = hotelDAO.selectCount();
		//计算总页数
		int pageCount = total % Page.PAGE_SIZE ==0 ? 
				total/Page.PAGE_SIZE : total/Page.PAGE_SIZE+1;
		//分页查询数据
		List<Hotel> hotels = hotelDAO.selectHotelsByPage((pageNo-1)*Page.PAGE_SIZE, pageSize);
		Page<Hotel> page = new Page<>();
		page.setCurrentPage(pageNo);
		page.setData(hotels);
		page.setPageCount(pageCount);
		return page;
	}

	@Override
	public HotelInfo findHotelInfoById(int hotelId) {
		return hotelDAO.selectHotelInfoById(hotelId);
	}

	@Override
	public List<Room> findRoomsById(int hotelId) {
		return hotelDAO.selectRoomsById(hotelId);
	}

	@Override
	public List<PackageInfo> findPackagesById(int hotelId) {
		return hotelDAO.selectPackagesById(hotelId);
	}

	@Override
	public Hotel findHotelsById(int hotelId) {
		return hotelDAO.selectHotelById(hotelId);
	}

}
