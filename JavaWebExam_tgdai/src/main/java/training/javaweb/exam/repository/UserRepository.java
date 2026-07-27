package training.javaweb.exam.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import training.javaweb.exam.dao.mapper.UserMapper;
import training.javaweb.exam.entity.User;

@Repository
public class UserRepository {
	private final UserMapper userMapper;

	public User findByUsername(String username) {
		Map<String, Object> param = new HashMap<>();
		param.put("username", username);

		return userMapper.findByUsername(param);
	}

	public int createUserAccount(User user) {
		Map<String, Object> param = new HashMap<>();
		param.put("username", user.getUsername());
		param.put("password", user.getPassword());
		param.put("role", user.getRole());
		param.put("ownerId", user.getOwnerId());
		param.put("enabled", user.getEnable());

		return userMapper.createUserAccount(param);
	}
	
	public int deleteUserByOwnerId(Long ownerId) {
		Map<String, Object> param = new HashMap<>();
		param.put("ownerId", ownerId);
		
		return userMapper.deleteUserByOwnerId(param);
	}

	public UserRepository(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

}