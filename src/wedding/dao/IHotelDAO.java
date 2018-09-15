package wedding.dao;

import java.util.List;

import wedding.entity.Hotel;
import wedding.entity.HotelInfo;
import wedding.entity.PackageInfo;
import wedding.entity.Room;
/**
 * 酒店数据访问接口
 * @author Tinmen
 *
 */
public interface IHotelDAO {
	/**
	 * 添加酒店
	 * @param hotel
	 */
	void addHotel(Hotel hotel);
	/**
	 * 查询所有酒店
	 * @return
	 */
    List<Hotel> selectAllHotels();
    /**
     * 查询总行数
     */
    int selectCount();
    /**
     * 分页查询酒店
     * @param pageNo 当前页数
     * @param pageSize 每页行数
     * @return
     */
    List<Hotel> selectHotelsByPage(int pageNo,int pageSize);
    /**
     * 按酒店id查询详情
     * @param hotelId
     * @return
     */
    HotelInfo selectHotelInfoById(int hotelId);
    /**
     * 按id查房间
     * @param hotelId
     * @return
     */
    List<Room> selectRoomsById(int hotelId);
    /**
     * 按id查套餐
     * @param hotelId
     * @return
     */
    List<PackageInfo> selectPackagesById(int hotelId);
    /**
     * 按酒店id查询酒店
     * @param hotelId
     * @return
     */
    Hotel selectHotelById(int hotelId);
}
