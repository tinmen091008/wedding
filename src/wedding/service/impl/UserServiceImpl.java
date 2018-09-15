package wedding.service.impl;

import java.util.List;

import wedding.dao.IUserDAO;
import wedding.dao.impl.UserDAOImpl;
import wedding.entity.User;
import wedding.service.IUserService;

public class UserServiceImpl implements IUserService{

	//创建UserDAO的对象
	private IUserDAO userDAO = new UserDAOImpl();
	
	@Override
	public User login(String userTel, String password) {
		User user =userDAO.selectUserByTel(userTel);
		System.out.print(user);
		//通过电话查询用户和密码是否正确
		if(user == null) {
			return null;
		}else if(userTel.equals(user.getUser_tel()) && password.equals(user.getUser_password())){
			return user;
		}else {
			return null;
		}
		
	}

	@Override
	public void register(User user) {
		userDAO.addUser(user);
	}

	@Override
	public void update(User user) {
		//先查询再更新，防止覆盖
		userDAO.selectUserByTel(user.getUser_tel());
		userDAO.updateUser(user);
	}

	@Override
	public void delete(int id) {
		userDAO.deleteUser(id);
		
	}

	@Override
	public User findUserById(int id) {
		return userDAO.selectUserById(id);
	}

	@Override
	public List<User> findAllUsers() {
		return userDAO.selectAllUsers();
	}

	
	@Override
	public User findUserByTel(String userTel) {
		return userDAO.selectUserByTel(userTel);
		
	}

}
