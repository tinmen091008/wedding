package wedding;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Before;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import wedding.dao.impl.UserDAOImpl;
import wedding.entity.User;
import wedding.service.IUserService;
import wedding.service.impl.UserServiceImpl;
//import com.mysql.jdbc.Connection;

public class Testwedding {
	@Test
	public void Jutil() {
		int n = 1;
		System.out.println("hello jutil"+n);
	}
	
	@Before
	public void Before() {
		System.out.println("hello Before");
	}
	
	@Test
	public void c3p0Test() {
		// TODO Auto-generated method stub
		ComboPooledDataSource com = new ComboPooledDataSource();
		try {
			Connection con = com.getConnection();
			System.out.println(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDBUtils(){
		//创建连接池
		ComboPooledDataSource pool = new ComboPooledDataSource();
		//创建SQL执行器
		QueryRunner runner = new QueryRunner(pool);
		//执行增删改操作,参数1是SQL语句，参数2之后都是SQL语句中的占位符参数
		try {
			runner.update("insert into tb_user(user_tel,user_password) values(?,?)", 
					"13009998888","123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDBUtilsSelect(){
		//创建连接池
		ComboPooledDataSource pool = new ComboPooledDataSource();
		//创建SQL执行器
		QueryRunner runner = new QueryRunner(pool);
		try {
			//查询多条数据,参数1 SQL语句，参数2 处理器的参数是实体类的类型，参数3 是占位符参数
			@SuppressWarnings({ "unchecked", "rawtypes" })
			List<User> users = (List<User>) runner.query("select * from tb_user", new BeanListHandler(User.class));
			for(User user : users){
				System.out.println("多条user--->"+user);
			}
			//查询单条数据
			@SuppressWarnings({ "unchecked", "rawtypes" })
			User user = (User) runner.query("select * from tb_user where user_id=?", new BeanHandler(User.class),3);
			System.out.println("单条user--->"+user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testIUserDAOImpl() {
		UserDAOImpl iUserDAOImpl = new UserDAOImpl();
		User user = new User();
		user.setUser_tel("1353333");
		user.setUser_password("233333");
		iUserDAOImpl.addUser(user);
		iUserDAOImpl.selectAllUsers();
		iUserDAOImpl.selectUserById(1);
		iUserDAOImpl.selectUserByTel("13420110963");
		iUserDAOImpl.deleteUser(1);
	}
	
	@Test
	public void testUserByTel() {
		IUserService userService = new UserServiceImpl();
		User user = userService.findUserByTel("13420110963");
		System.out.println(user);
	}
}
