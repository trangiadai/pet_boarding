package training.javaweb.exam.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import training.javaweb.exam.entity.Owner;

@Mapper
public interface OwnerMapper {
	List<Owner> getAllOwners();

	int createOwner(Map<String, Object> param);

	int updateOwner(Map<String, Object> param);

	Owner getOwnerById(Map<String, Object> param);

	List<Owner> searchOwners(Map<String, Object> param);

	int deleteOwnerById(Map<String, Object> param);
}
