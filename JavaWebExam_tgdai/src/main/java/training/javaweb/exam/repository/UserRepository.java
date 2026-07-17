package training.javaweb.exam.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import training.javaweb.exam.dao.mapper.UserMapper;
import training.javaweb.exam.entity.User;

@Repository
public class UserRepository {
	private final UserMapper userMapper;
	
	public boolean userExists(String username) {
		Map<String, Object> param = new HashMap<>();
		param.put("username", username);
		
		return userMapper.countUserByUsername(param) > 0;
	}

	@Transactional
	public int createCustomerAccount(User user) {
		Map<String, Object> param = new HashMap<>();
		param.put("username", user.getUsername());
		param.put("password", user.getPassword());
		param.put("role", user.getRole());
		param.put("ownerId", user.getOwnerId());
		param.put("enabled", user.getEnable());
		param.put("createdAt", user.getCreatedAt());
		
		return userMapper.createUserAccount(param);
	}

	public UserRepository(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}
	

}
