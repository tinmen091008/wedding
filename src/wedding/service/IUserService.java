package wedding.service;

import java.util.List;

import wedding.entity.User;

/**
 * 业务逻辑接口
 * @author Tinmen
 *
 */
public interface IUserService {
	/**
	 * 登录业务逻辑
	 * @param userTel
	 * @param password
	 * @return
	 */
	public User login(String userTel,String password);
	/**
	 * 注册业务逻辑
	 * @param user
	 */
	public void register(User user);
	/**
	 * 更新
	 * @param user
	 */
	public void update(User user);
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	public User findUserById(int id);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAllUsers();	
	/**
	 * 通过电话查询用户
	 * @param userTel
	 * @return
	 */
	public User findUserByTel(String userTel);
}
