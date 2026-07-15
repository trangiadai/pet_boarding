package training.javaweb.exam.service;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import ch.qos.logback.classic.pattern.Util;
import jakarta.validation.Valid;
import training.javaweb.exam.dto.mapper.OwnerMapperDTO;
import training.javaweb.exam.dto.request.OwnerRequestDTO;
import training.javaweb.exam.dto.response.OwnerResponseDTO;
import training.javaweb.exam.entity.Owner;
import training.javaweb.exam.repository.OwnerRepository;
import training.javaweb.exam.utils.Helper;

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

		return OwnerMapperDTO.toOwnerResponse(ownerRepository.createOwner(owner));
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

	public OwnerService(OwnerRepository ownerRepository) {
		super();
		this.ownerRepository = ownerRepository;
	}

}
