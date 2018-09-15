package wedding.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wedding.entity.Hotel;
import wedding.entity.Page;
import wedding.service.IHotelService;
import wedding.service.impl.HotelServiceImpl;

/**
 * 分页查询酒店的servlet
 * @author Tinmen
 *
 */

@WebServlet("/findHotelsByPage.do")
public class FindHotelsByPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获得当前页数的参数
		String pageNo = req.getParameter("pageNo");
		if(pageNo == null) {
			throw new RuntimeException("当前页数为空");
		}
		int no = Integer.parseInt(pageNo);
		IHotelService hotelService = new HotelServiceImpl();
		Page<Hotel> page = hotelService.findHotelsByPage(no,Page.PAGE_SIZE);
		req.setAttribute("page", page);
		req.getRequestDispatcher("hotel.jsp").forward(req, resp);
		req.getAttribute("page");
	}
}
