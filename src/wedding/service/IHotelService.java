package wedding.service;

import java.util.List;

import wedding.entity.Hotel;
import wedding.entity.HotelInfo;
import wedding.entity.PackageInfo;
import wedding.entity.Page;
import wedding.entity.Room;

/**
 * 酒店业务逻辑接口
 * @author Tinmen
 *
 */
public interface IHotelService {
	/**
	 * 查询所有酒店
	 * @return
	 */
	public List<Hotel> findAllHotels();
	
	/**
	 * 分页查询酒店
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<Hotel> findHotelsByPage(int pageNo,int pageSize);
    /**
     * 按酒店id查询详情
     * @param hotelId
     * @return
     */
    HotelInfo findHotelInfoById(int hotelId);
    /**
     * 按id查房间
     * @param hotelId
     * @return
     */
    List<Room> findRoomsById(int hotelId);
    /**
     * 按id查套餐
     * @param hotelId
     * @return
     */
    List<PackageInfo> findPackagesById(int hotelId);
    /**
     * 按照id查酒店
     * @param hotelId
     * @return
     */
    Hotel findHotelsById(int hotelId);
}
