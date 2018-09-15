package wedding.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wedding.entity.Hotel;
import wedding.entity.HotelInfo;
import wedding.entity.PackageInfo;
import wedding.entity.Room;
import wedding.service.IHotelService;
import wedding.service.impl.HotelServiceImpl;

/**
 * 查看酒店详情的servlet
 * @author Tinmen
 *
 */

@WebServlet("/findHotelInfo.do")
public class FindHotelInfoServlet extends HttpServlet{
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
		String id = req.getParameter("hotelId");
		if(id == null) {
			throw new RuntimeException("没有酒店ID");
		}
		int hotelId = Integer.parseInt(id);
		
		IHotelService hotelService = new HotelServiceImpl();
		HotelInfo hotelInfo = hotelService.findHotelInfoById(hotelId);
		List<Room> rooms = hotelService.findRoomsById(hotelId);
		List<PackageInfo> packages = hotelService.findPackagesById(hotelId);
		Hotel hotel = hotelService.findHotelsById(hotelId);
		req.setAttribute("hotelInfo", hotelInfo);
		req.setAttribute("rooms", rooms);
		req.setAttribute("packages", packages);
		req.setAttribute("hotel", hotel);
		req.getRequestDispatcher("hotelDetails.jsp").forward(req, resp);
		
	}
}
