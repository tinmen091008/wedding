package wedding.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateCode.do")
public class VaildateCodeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int WIDTH = 95;
	private static final int HEIGHT = 35;
	private static final int FONT_SIZE = 20;
	private static final Color[] COLORS = {Color.RED,Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,
			Color.MAGENTA,Color.ORANGE,Color.PINK,Color.YELLOW};
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//定义字符数组，用于保存验证码
		char[] codes = new char[4];
		//创建缓冲图片
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
		//创建图形对象
		Graphics graphics = image.getGraphics();
		//设置颜色作为图片的底色
		graphics.setColor(Color.GRAY);
		//填充矩形的区域
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		//设置字体
		graphics.setFont(new Font("宋体",Font.BOLD,FONT_SIZE));
		//随机选择四个数字或字母
		Random random = new Random();
		for(int i = 0;i < 4;i++){
			//获得字符
			int index = random.nextInt(CODES.length());
			char c = CODES.charAt(index);
			codes[i] = c;
			//随机选择颜色
			graphics.setColor(COLORS[random.nextInt(COLORS.length)]);
			//绘制文字
			graphics.drawString(String.valueOf(c), i * FONT_SIZE + 10, FONT_SIZE);
			//绘制随机线条
			graphics.setColor(COLORS[random.nextInt(COLORS.length)]);
			graphics.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT), 
					random.nextInt(WIDTH), random.nextInt(HEIGHT));
		}
		//把字符串保存到Session中
		req.getSession().setAttribute("code", new String(codes));
		//将图片通过流发送给浏览器端
		ImageIO.write(image, "PNG", resp.getOutputStream());
	}
}