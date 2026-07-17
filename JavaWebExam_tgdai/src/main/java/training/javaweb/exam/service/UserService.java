package training.javaweb.exam.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.javaweb.exam.dto.mapper.UserMapperDTO;
import training.javaweb.exam.dto.request.UserRequestDTO;
import training.javaweb.exam.dto.response.UserResponseDTO;
import training.javaweb.exam.entity.Owner;
import training.javaweb.exam.entity.User;
import training.javaweb.exam.repository.OwnerRepository;
import training.javaweb.exam.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final OwnerRepository ownerRepository;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	public UserResponseDTO createCustomerAccount(UserRequestDTO userRequest) {
		String password = userRequest.getPassword();
		Owner owner = ownerRepository.getOwnerById(userRequest.getOwnerId());
		if (owner == null) {
			throw new RuntimeException("Cannot create account. Owner details not found.");
		}

		String username = owner.getPhone();
		if (userRepository.userExists(username)) {
			throw new RuntimeException("Account with this phone number already exists.");
		}

		
		User user = UserMapperDTO.toUser(userRequest);
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		userRepository.createCustomerAccount(user);

		return UserMapperDTO.toUserReponse(user);
	}

	public UserService(UserRepository userRepository, OwnerRepository ownerRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.ownerRepository = ownerRepository;
		this.passwordEncoder = passwordEncoder;
	}

}
