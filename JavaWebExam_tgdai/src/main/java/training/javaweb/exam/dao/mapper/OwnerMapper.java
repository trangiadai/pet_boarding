package training.javaweb.exam.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import training.javaweb.exam.entity.Owner;

@Mapper
public interface OwnerMapper {
	List<Owner> getAllOwners();
	
	int createOwner(Map<String, Object> param);
}
