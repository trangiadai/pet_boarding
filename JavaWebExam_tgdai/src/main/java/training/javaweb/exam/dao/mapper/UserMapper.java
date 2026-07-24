package training.javaweb.exam.dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import training.javaweb.exam.entity.User;

@Mapper
public interface UserMapper {
	int createUserAccount(Map<String, Object> param);

	int deleteUserByOwnerId(Map<String, Object> param);

	User findByUsername(Map<String, Object> param);
}
