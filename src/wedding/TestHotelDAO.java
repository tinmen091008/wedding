package wedding;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import wedding.dao.IHotelDAO;
import wedding.dao.impl.HotelDAOImpl;
import wedding.entity.Hotel;

public class TestHotelDAO {
	
	private IHotelDAO dao = new HotelDAOImpl();
	
	@Test
	public void testHotel() {
//		List<Hotel> hotels = Arrays.asList(new Hotel(3,"香格里拉大酒店","香格里拉五龙镇","3","20161022100789.jpg"),
//				new Hotel(4,"香格里拉小酒店","香格里拉泸定县","2","20160819434004.jpg"));
//		for(Hotel hotel : hotels){
//			dao.addHotel(hotel);
//		}
		
//		for(int i=0;i<100;i++){
//			dao.addHotel(new Hotel(4,"香格里拉小酒店"+i,"香格里拉泸定县","2","20160819434004.jpg"));
//		}
		
		int count = dao.selectCount();
		System.out.println(count);
		
		
	}
}
