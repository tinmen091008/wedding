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
 * 用户操作的Servlet
 * @author Tinmen
 *
 */
@WebServlet("/login.do")
public class UserLoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置字符乱码，解决中文乱码
		req.setCharacterEncoding("UTF-8");
		//解决响应流中的乱码
		resp.setContentType("text/html;charset=UTF-8");
		//获得请求参数
		String user_tel = req.getParameter("user_tel");
		String password = req.getParameter("password");
		
	    //获得Session中的验证码
			String vcode = (String) req.getSession().getAttribute("code");
			String user_vcode = req.getParameter("vcode");
			//判断验证码
			if(vcode == null || !vcode.equals(user_vcode)){
				//向request存入错误信息
				req.setAttribute("error_msg", "验证码错误");
				//跳回login.jsp
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				return;
			}

		System.out.println("手机号：" + user_tel);
		System.out.println("密码：" + password);
		if(user_tel==null || password==null) {
			throw new RuntimeException("账号或密码错误");
		}
		//创建User表业务逻辑对象
		IUserService userService = new UserServiceImpl();
		//登录验证
		User user = userService.login(user_tel, password);
		if(user == null) {
//			resp.getWriter().println("账号或密码错误");
		//向request存入一个错误信息
			req.setAttribute("error_msg", "账号或密码错误");
		//调回登录页面
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}else {
//		//重定向到首页
//			resp.sendRedirect("index.jsp");
		//使用forward调到首页
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
