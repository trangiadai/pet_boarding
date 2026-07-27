package training.javaweb.exam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.javaweb.exam.dto.mapper.PetMapperDTO;
import training.javaweb.exam.dto.request.PetRequestDTO;
import training.javaweb.exam.dto.response.PetResponseDTO;
import training.javaweb.exam.entity.Pet;
import training.javaweb.exam.enums.PetType;
import training.javaweb.exam.repository.PetRepository;
import training.javaweb.exam.security.CustomUserDetails;

@Service
public class PetService {
	private PetRepository petRepository;

	public PetResponseDTO createPet(PetRequestDTO petRequest) {
		Pet pet = petRepository.getPetByPetNameAndTypeAndOwnerId(petRequest.getName(), petRequest.getType().name(),
				petRequest.getOwnerId());
		if (pet != null) {
			throw new IllegalArgumentException("One owner can't have 2 pets be the same name and type");
		}

		return PetMapperDTO.toPetResponse(petRepository.createPet(PetMapperDTO.toPet(petRequest)));
	}

	public List<PetResponseDTO> getAllPets() {
		return petRepository.getAllPets().stream().map(pet -> {
			return PetMapperDTO.toPetResponse(pet);
		}).collect(Collectors.toList());
	}

	public PetResponseDTO getPetById(Long id) {
		return PetMapperDTO.toPetResponse(petRepository.getPetById(id));
	}

	@Transactional
	public PetResponseDTO updatePetById(Long id, PetRequestDTO petRequest) {
		Pet existingPet = petRepository.getPetById(id);
		if (existingPet == null) {
			throw new RuntimeException("Pet with ID " + id + " not found.");
		}

		Pet pet = petRepository.getPetByPetNameAndTypeAndOwnerId(petRequest.getName(), petRequest.getType().name(),
				petRequest.getOwnerId());
		if (pet != null && pet.getId() != id) {
			throw new IllegalArgumentException("One owner can't have 2 pets be the same name and type");
		}

		existingPet.setName(petRequest.getName());
		existingPet.setType(petRequest.getType().name().toLowerCase());
		existingPet.setBreed(petRequest.getBreed());
		existingPet.setAge(petRequest.getAge());
		existingPet.setWeight(petRequest.getWeight());
		existingPet.setImageUrl(petRequest.getImageUrl());
		existingPet.setOwnerId(petRequest.getOwnerId());

		petRepository.updatePetById(existingPet);
		return PetMapperDTO.toPetResponse(petRepository.getPetById(existingPet.getId()));
	}

	@Transactional
	public int deletePetById(Long id) {
		Pet existing = petRepository.getPetById(id);
		if (existing == null) {
			throw new RuntimeException("Pet with ID " + id + " not found.");
		}
		return petRepository.deletePetById(id);
	}

	public List<PetResponseDTO> findPetsFiltered(List<String> rawTypes) {
		List<String> types = new ArrayList<>();
		if (rawTypes != null && !rawTypes.isEmpty()) {
			for (String rawType : rawTypes) {
				if (rawType != null && !rawType.isEmpty()) {
					try {
						PetType type = PetType.valueOf(rawType.trim().toUpperCase());
						types.add(type.name());
					} catch (IllegalArgumentException e) {
						throw new IllegalArgumentException("Unknown pet's type: " + rawType);
					}

				}
			}
		}

		return petRepository.findPetsFiltered(types).stream().map(pet -> {
			return PetMapperDTO.toPetResponse(pet);
		}).collect(Collectors.toList());
	}

	public List<PetResponseDTO> searchPetByOwnerName(String name) {

		return petRepository.searchPetByOwnerName(name).stream().map(pet -> {
			return PetMapperDTO.toPetResponse(pet);
		}).collect(Collectors.toList());
	}

	public List<PetResponseDTO> getMyPets(CustomUserDetails userDetails) {
		Long ownerId = userDetails.getOwnerId();
		return petRepository.getPetsByOwnerId(ownerId).stream().map(pet -> {
			return PetMapperDTO.toPetResponse(pet);
		}).collect(Collectors.toList());
	}
	
	public int deletePetsByOwnerId(Long ownerId) {
		
		return petRepository.deletePetsByOwnerId(ownerId);
	}

	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

}