package xyz.yuelai.blog.service;

import java.util.List;
import java.util.Map;

import xyz.yuelai.blog.entity.User;
import xyz.yuelai.blog.util.PageInfoUtil;

public interface IUserService {
	/**
	 * 保存用户
	 * 
	 * @param user
	 *            待保存用户
	 */
	void saveUser(User user);
	
	/**
	 * 根据id删除用户
	 * @param id
	 */

	void deleteUser(Integer id);

	/**
	 * 根据id更新用户
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 获取单个用户
	 * 
	 * @param conditionMap
	 *            条件map 查询条件为userID or email
	 * @return 获取到的用户,获取不到返回null
	 */
	User getUser(Map<String, Object> conditionMap);

	/**
	 * 获取用户list
	 * 
	 * @param pageInfoUtil
	 *            分页信息
	 * @param conditionMap
	 *            条件map
	 * @return 用户list
	 */
	List<User> getUserList(PageInfoUtil pageInfoUtil,
			Map<String, Object> conditionMap);
}
