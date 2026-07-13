package training.javaweb.exam.dto.mapper;

import training.javaweb.exam.dto.request.OwnerRequestDTO;
import training.javaweb.exam.dto.response.OwnerResponseDTO;
import training.javaweb.exam.entity.Owner;

public class OwnerMapperDTO {
	public static OwnerResponseDTO toOwnerResponse(Owner owner) {
		if (owner == null) {
			return null;
		}

		OwnerResponseDTO ownerResponse = new OwnerResponseDTO();
		ownerResponse.setName(owner.getName());
		ownerResponse.setPhone(owner.getPhone());
		ownerResponse.setEmail(owner.getEmail());
		ownerResponse.setAddress(owner.getAddress());
		ownerResponse.setCreatedAt(owner.getCreatedAt());

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
