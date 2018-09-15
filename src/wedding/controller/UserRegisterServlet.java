package wedding.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wedding.dao.IUserDAO;
import wedding.dao.impl.UserDAOImpl;
import wedding.entity.User;
import wedding.service.IUserService;
import wedding.service.impl.UserServiceImpl;

@WebServlet("/register.do")
public class UserRegisterServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//创建UserDAO的对象
	private IUserDAO userDAO = new UserDAOImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置字符乱码，解决中文乱码
				req.setCharacterEncoding("UTF-8");
				//解决响应流中的乱码
				resp.setContentType("text/html;charset=UTF-8");
				//获得请求参数
				String user_tel = req.getParameter("user_tel");
				String password = req.getParameter("password");
				
				//创建User表业务逻辑对象
				IUserService userService = new UserServiceImpl();
				//注册
				User user = new User();
				user.setUser_tel(user_tel);
				user.setUser_password(password);
//				//若输入为空，则返回错误提示
				if(user_tel.equals("") || password.equals("")) {
				//错误提示
					req.setAttribute("error_msg", "账号或密码为空");
				}else {
				//注册成功并返回登录界面
					userService.register(user);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
	}
}
