package training.javaweb.exam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.javaweb.exam.dto.mapper.OwnerMapperDTO;
import training.javaweb.exam.dto.request.OwnerRequestDTO;
import training.javaweb.exam.dto.request.UserRequestDTO;
import training.javaweb.exam.dto.response.OwnerResponseDTO;
import training.javaweb.exam.dto.response.UserResponseDTO;
import training.javaweb.exam.entity.Owner;
import training.javaweb.exam.entity.User;
import training.javaweb.exam.repository.OwnerRepository;

@Service
public class OwnerService {
	private final OwnerRepository ownerRepository;
	private final UserService userService;

	public List<OwnerResponseDTO> getAllOwners() {
		List<OwnerResponseDTO> ownerResponses = ownerRepository.getAllOwners().stream().map(owner -> {
			return OwnerMapperDTO.toOwnerResponse(owner);
		}).collect(Collectors.toList());

		return ownerResponses;
	}

	public OwnerResponseDTO getOwnerById(Long id) {

		return OwnerMapperDTO.toOwnerResponse(ownerRepository.getOwnerById(id));
	}

	@Transactional
	public OwnerResponseDTO createOwner(OwnerRequestDTO ownerRequest) {
		Owner owner = OwnerMapperDTO.toOwner(ownerRequest);
		OwnerResponseDTO ownerReponse = OwnerMapperDTO.toOwnerResponse(ownerRepository.createOwner(owner));

		UserRequestDTO userRequest = ownerRequest.getUserRequest();
		if (userRequest != null) {
			userRequest.setOwnerId(ownerReponse.getId());
			userService.createCustomerAccount(userRequest);
		}

		return OwnerMapperDTO.toOwnerResponse(ownerRepository.getOwnerById(ownerReponse.getId()));
	}

	@Transactional
	public OwnerResponseDTO updateOwner(Long id, OwnerRequestDTO ownerRequest) {
		Owner existingOwner = ownerRepository.getOwnerById(id);
		if (existingOwner == null) {
			throw new RuntimeException("Owner not found with ID: " + id);
		}

		existingOwner.setName(ownerRequest.getName());
		existingOwner.setPhone(ownerRequest.getPhone());
		existingOwner.setEmail(ownerRequest.getEmail());
		existingOwner.setAddress(ownerRequest.getAddress());
		ownerRepository.updateOwner(existingOwner);
		return OwnerMapperDTO.toOwnerResponse(ownerRepository.getOwnerById(id));
	}

	public List<OwnerResponseDTO> searchOwners(String keyword) {
		return ownerRepository.searchOwners(keyword).stream().map(owner -> {
			return OwnerMapperDTO.toOwnerResponse(owner);
		}).collect(Collectors.toList());
	}

	@Transactional
	public int deleteOwnerById(Long id) {
		Owner existingOwner = ownerRepository.getOwnerById(id);
		if (existingOwner == null) {
			throw new RuntimeException("Owner profile not found with ID: " + id);
		}
		return ownerRepository.deleteOwnerById(id);
	}

	public OwnerService(OwnerRepository ownerRepository, UserService userService) {
		super();
		this.ownerRepository = ownerRepository;
		this.userService = userService;
	}

}
