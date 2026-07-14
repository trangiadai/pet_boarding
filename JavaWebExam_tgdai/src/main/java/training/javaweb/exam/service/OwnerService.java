package training.javaweb.exam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import training.javaweb.exam.dto.mapper.OwnerMapperDTO;
import training.javaweb.exam.dto.request.OwnerRequestDTO;
import training.javaweb.exam.dto.response.OwnerResponseDTO;
import training.javaweb.exam.entity.Owner;
import training.javaweb.exam.repository.OwnerRepository;

@Service
public class OwnerService {
	private final OwnerRepository ownerRepository;

	public List<OwnerResponseDTO> getAllOwners() {
		List<OwnerResponseDTO> ownerResponses = ownerRepository.getAllOwners().stream().map(owner -> {
			return OwnerMapperDTO.toOwnerResponse(owner);
		}).collect(Collectors.toList());

		return ownerResponses;
	}
	
	public OwnerResponseDTO createOwner(OwnerRequestDTO ownerRequest) {
		Owner owner = OwnerMapperDTO.toOwner(ownerRequest);
		
		return OwnerMapperDTO.toOwnerResponse(ownerRepository.createOwner(owner))  ;
	}

	public OwnerService(OwnerRepository ownerRepository) {
		super();
		this.ownerRepository = ownerRepository;
	}

}
