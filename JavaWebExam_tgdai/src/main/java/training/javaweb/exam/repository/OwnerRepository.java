package training.javaweb.exam.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import training.javaweb.exam.dao.mapper.OwnerMapper;
import training.javaweb.exam.entity.Owner;

@Repository
public class OwnerRepository {
	private final OwnerMapper ownerMapper;

	public List<Owner> getAllOwners() {
		return ownerMapper.getAllOwners();
	}

	public OwnerRepository(OwnerMapper ownerMapper) {
		super();
		this.ownerMapper = ownerMapper;
	}
}
