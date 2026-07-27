package training.javaweb.exam.dto.mapper;

import training.javaweb.exam.dto.request.PetRequestDTO;
import training.javaweb.exam.dto.response.PetResponseDTO;
import training.javaweb.exam.entity.Pet;
import training.javaweb.exam.enums.BoardingStatus;
import training.javaweb.exam.enums.PetType;

public class PetMapperDTO {
	
	public static PetResponseDTO toPetResponse(Pet pet) {
		if (pet == null) {
			return null;
		}

		PetResponseDTO petResponse = new PetResponseDTO();
		petResponse.setId(pet.getId());
		petResponse.setName(pet.getName());
		if (pet.getType() != null) {
			petResponse.setType(PetType.valueOf(pet.getType().toUpperCase()));
		}
		petResponse.setBreed(pet.getBreed());
		petResponse.setAge(pet.getAge());
		petResponse.setWeight(pet.getWeight());
		petResponse.setImageUrl(pet.getImageUrl());
		petResponse.setOwnerId(pet.getOwnerId());
		petResponse.setCreatedAt(pet.getCreatedAt());
		petResponse.setOwner(OwnerMapperDTO.toOwnerResponse(pet.getOwner()));

		if (pet.getStatus() != null) {
			try {
				petResponse.setStatus(BoardingStatus.valueOf(pet.getStatus().toUpperCase()));
			} catch (IllegalArgumentException e) {
				petResponse.setStatus(null);
			}
		} else {
			petResponse.setStatus(null);
		}

		return petResponse;
	}

	public static Pet toPet(PetRequestDTO petRequest) {
		if (petRequest == null) {
			return null;
		}

		Pet pet = new Pet();
		pet.setName(petRequest.getName());
		pet.setType(petRequest.getType().name().toLowerCase());
		pet.setBreed(petRequest.getBreed());
		pet.setAge(petRequest.getAge());
		pet.setWeight(petRequest.getWeight());
		pet.setImageUrl(petRequest.getImageUrl());
		pet.setOwnerId(petRequest.getOwnerId());

		return pet;
	}

}