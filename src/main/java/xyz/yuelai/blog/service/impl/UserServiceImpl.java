package xyz.yuelai.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import xyz.yuelai.blog.dao.IUserDAO;
import xyz.yuelai.blog.entity.User;
import xyz.yuelai.blog.service.IUserService;
import xyz.yuelai.blog.util.PageInfoUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public void saveUser(User user) {
		Map<String, Object> conditionMap = new HashMap<>();
		conditionMap.put("id", 1);
		User quser = userDAO.getUser(conditionMap);
		quser.setUsername("asasa");
		userDAO.saveUser(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userDAO.deleteUser(id);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public User getUser(Map<String, Object> conditionMap) {
		return userDAO.getUser(conditionMap);
	}

	@Override
	public List<User> getUserList(PageInfoUtil pageInfoUtil,
			Map<String, Object> conditionMap) {
		if (pageInfoUtil != null) {
			Page<User> page = PageHelper.startPage(
					pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
			List<User> userList = userDAO.getUserList(conditionMap);
			pageInfoUtil.setTotalRecord((int) page.getTotal());
			return userList;
		}
		return userDAO.getUserList(conditionMap);
	}

}
