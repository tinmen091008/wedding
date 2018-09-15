package wedding.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wedding.entity.User;
import wedding.service.IUserService;
import wedding.service.impl.UserServiceImpl;

/**
 * 验证手机号是否存在
 * @author Tinmen
 *
 */
@WebServlet("/checkTel.do")
public class FindUserByTelServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//接收Ajax函数传来的手机号
		String user_tel = req.getParameter("userTel");
		//解决响应流中的乱码
		resp.setContentType("text/html;charset=UTF-8");
		//调用数据库查询
		IUserService service = new UserServiceImpl();
		User user = service.findUserByTel(user_tel);
		System.out.println(user_tel);
		System.out.println(user);
		
		if(user == null) {
			resp.getWriter().println("此手机号可以使用");
		}else {
			resp.getWriter().println("此手机号已经存在");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
