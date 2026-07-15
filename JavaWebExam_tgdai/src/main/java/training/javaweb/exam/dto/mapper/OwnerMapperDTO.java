package training.javaweb.exam.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import training.javaweb.exam.dto.request.OwnerRequestDTO;
import training.javaweb.exam.dto.response.OwnerResponseDTO;
import training.javaweb.exam.entity.Owner;
import training.javaweb.exam.entity.Pet;

public class OwnerMapperDTO {
	public static OwnerResponseDTO toOwnerResponse(Owner owner) {
		if (owner == null) {
			return null;
		}

		OwnerResponseDTO ownerResponse = new OwnerResponseDTO();
		ownerResponse.setId(owner.getId());
		ownerResponse.setName(owner.getName());
		ownerResponse.setPhone(owner.getPhone());
		ownerResponse.setEmail(owner.getEmail());
		ownerResponse.setAddress(owner.getAddress());
		ownerResponse.setCreatedAt(owner.getCreatedAt());
		List<Pet> pets = owner.getPets();
		if (pets != null && !pets.isEmpty()) {
			ownerResponse.setPets(pets.stream().map(pet -> {
				return PetMapperDTO.toPetResponse(pet);
			}).collect(Collectors.toList()));
		} else {
			ownerResponse.setPets(null);
		}

		return ownerResponse;
	}

	public static Owner toOwner(OwnerRequestDTO ownerRequest) {
		if (ownerRequest == null) {
			return null;
		}

		Owner owner = new Owner();
		owner.setName(ownerRequest.getName());
		owner.setPhone(ownerRequest.getPhone());
		owner.setEmail(ownerRequest.getEmail());
		owner.setAddress(ownerRequest.getAddress());
		owner.setCreatedAt(ownerRequest.getCreatedAt());

		return owner;
	}

}
