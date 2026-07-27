package training.javaweb.exam.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import training.javaweb.exam.dao.mapper.OwnerMapper;
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

		ownerMapper.createOwner(param);
		Number generatedIdObj = (Number) param.get("id");
		if (generatedIdObj != null) {
			owner.setId(generatedIdObj.longValue());
		}

		return owner;
	}

	public int updateOwner(Owner owner) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", owner.getId());
		param.put("name", owner.getName());
		param.put("phone", owner.getPhone());
		param.put("email", owner.getEmail());
		param.put("address", owner.getAddress());

		return ownerMapper.updateOwner(param);
	}

	public Owner getOwnerById(Long id) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);

		return ownerMapper.getOwnerById(param);
	}

	public List<Owner> searchOwners(String keyword) {
		Map<String, Object> param = new HashMap<>();
		param.put("keyword", keyword);
		return ownerMapper.searchOwners(param);
	}

	public int deleteOwnerById(Long id) {
		Map<String, Object> param = new HashMap<>();
		param.put("ownerId", id);

		return ownerMapper.deleteOwnerById(param);
	}

	public OwnerRepository(OwnerMapper ownerMapper) {
		super();
		this.ownerMapper = ownerMapper;
	}
}