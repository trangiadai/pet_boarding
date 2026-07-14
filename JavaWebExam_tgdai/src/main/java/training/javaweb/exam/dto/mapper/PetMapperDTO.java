package training.javaweb.exam.dto.mapper;

import training.javaweb.exam.dto.request.PetRequestDTO;
import training.javaweb.exam.dto.response.PetResponseDTO;
import training.javaweb.exam.entity.Pet;
import training.javaweb.exam.enums.PetType;

public class PetMapperDTO {
	public static PetResponseDTO toPetResponse(Pet pet) {
		if (pet == null) {
			return null;
		}

		PetResponseDTO petResponse = new PetResponseDTO();
		petResponse.setId(pet.getId());
		petResponse.setName(pet.getName());
		petResponse.setType(PetType.valueOf(pet.getType().toUpperCase()));
		petResponse.setBreed(pet.getBreed());
		petResponse.setAge(pet.getAge());
		petResponse.setWeight(pet.getWeight());
		petResponse.setImageUrl(pet.getImageUrl());
		petResponse.setOwnerId(pet.getOwnerId());
		petResponse.setCreatedAt(pet.getCreatedAt());

		return petResponse;
	}

	public static Pet toPet(PetRequestDTO petRequest) {
		if (petRequest == null) {
			return null;
		}

		Pet pet = new Pet();
		pet.setName(pet.getName());
		pet.setType(petRequest.getType().name().toLowerCase());
		pet.setBreed(pet.getBreed());
		pet.setAge(pet.getAge());
		pet.setWeight(pet.getWeight());
		pet.setImageUrl(pet.getImageUrl());
		pet.setOwnerId(pet.getOwnerId());
		pet.setCreatedAt(pet.getCreatedAt());

		return pet;
	}

}
