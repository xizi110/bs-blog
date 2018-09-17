package xyz.yuelai.blog.dao;

import java.util.List;
import java.util.Map;

import xyz.yuelai.blog.entity.User;

public interface IUserDAO {

	/**
	 * 添加一个用户
	 * 
	 * @param user
	 *            待添加的用户
	 */
	void saveUser(User user);

	/**
	 * 根据id删除一个用户
	 * 
	 * @param id
	 *            待删除用户的id
	 */
	void deleteUser(Integer userID);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 *            待更新用户,必须包含id
	 */
	void updateUser(User user);

	/**
	 * 获取单个用户
	 * @param conditionMap	条件map
	 * @return	获取到的用户,获取不到返回null
	 */
	User getUser(Map<String, Object> conditionMap);

	/**
	 * 获取用户list
	 * @param conditionMap	条件map
	 * @return	用户list
	 */
	List<User> getUserList(Map<String, Object> conditionMap);
}
