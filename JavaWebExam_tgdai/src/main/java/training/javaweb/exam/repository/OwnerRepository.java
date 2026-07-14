package training.javaweb.exam.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import training.javaweb.exam.dao.mapper.OwnerMapper;
import training.javaweb.exam.dto.mapper.OwnerMapperDTO;
import training.javaweb.exam.dto.request.OwnerRequestDTO;
import training.javaweb.exam.dto.response.OwnerResponseDTO;
import training.javaweb.exam.entity.Owner;

@Repository
public class OwnerRepository {
	private final OwnerMapper ownerMapper;

	public List<Owner> getAllOwners() {
		return ownerMapper.getAllOwners();
	}

	public Owner createOwner(Owner owner) {
		Map<String, Object> param = new HashMap<>();
		param.put("name", owner.getName());
		param.put("phone", owner.getPhone());
		param.put("email", owner.getEmail());
		param.put("address", owner.getAddress());
		param.put("createdAt", owner.getCreatedAt());
		
		ownerMapper.createOwner(param);
		Number generatedIdObj = (Number) param.get("id");
		if (generatedIdObj != null) {
			owner.setId(generatedIdObj.longValue());
		}
		
		return owner;
	}

	public OwnerRepository(OwnerMapper ownerMapper) {
		super();
		this.ownerMapper = ownerMapper;
	}
}
