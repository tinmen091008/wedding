package wedding.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wedding.dao.IHotelDAO;
import wedding.entity.Hotel;
import wedding.service.IHotelService;
import wedding.service.impl.HotelServiceImpl;
/**
 * 酒店信息操作
 * @author Tinmen
 *
 */

@WebServlet("/findAllHotels.do")
public class FindAllHotelServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		IHotelService hotelService = new HotelServiceImpl();
//		req.setAttribute("hotels", hotelService.findAllHotels());
//		
//		@SuppressWarnings("unchecked")
//		List<Hotel> list = (List<Hotel>) req.getAttribute("hotels");
//		System.out.println(list);
		
		//创建Service对象
		IHotelService service = new HotelServiceImpl();
		//查询酒店
		List<Hotel> hotels =service.findAllHotels();
		//保存到request中
		req.setAttribute("hotels", hotels);
		//跳转到hotel.jsp页面
		req.getRequestDispatcher("hotel.jsp").forward(req, resp);
	}
}
