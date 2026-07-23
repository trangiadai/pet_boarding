package training.javaweb.exam.dto.mapper;


import training.javaweb.exam.dto.request.UserRequestDTO;
import training.javaweb.exam.dto.response.UserResponseDTO;
import training.javaweb.exam.entity.User;
import training.javaweb.exam.enums.UserRole;

public class UserMapperDTO {

	public static User toUser(UserRequestDTO userRequest) {
		if(userRequest == null) {
			return null;
		}
		
		User user = new User();
		user.setPassword(userRequest.getPassword());
		user.setRole(UserRole.ROLE_CUSTOMER.name());
		user.setOwnerId(userRequest.getOwnerId());
		user.setEnable(userRequest.getEnable());
		user.setCreatedAt(userRequest.getCreatedAt());
		
		return user;
	}
	
	public static UserResponseDTO toUserReponse(User user) {
		if(user == null) {
			return null;
		}
		
		UserResponseDTO userReponse = new UserResponseDTO();
		userReponse.setUsername(user.getUsername());
		userReponse.setEnable(user.getEnable());
		
		return userReponse;
	}
}
