package training.javaweb.exam.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import training.javaweb.exam.dao.mapper.PetMapper;
import training.javaweb.exam.entity.Pet;

@Repository
public class PetRepository {
	private PetMapper petMapper;

	public Pet createPet(Pet pet) {
		Map<String, Object> param = new HashMap<>();
		param.put("name", pet.getName());
		param.put("type", pet.getType());
		param.put("breed", pet.getBreed());
		param.put("age", pet.getAge());
		param.put("weight", pet.getWeight());
		param.put("imageUrl", pet.getImageUrl());
		param.put("ownerId", pet.getOwnerId());

		petMapper.createPet(param);
		Number generatedId = (Number) param.get("id");
		if (generatedId != null) {
			pet.setId(generatedId.longValue());
		}
		return pet;
	}

	public List<Pet> getAllPets() {
		return petMapper.getAllPets();
	}

	public Pet getPetById(Long id) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		return petMapper.getPetById(param);
	}

	public Pet getPetByPetNameAndTypeAndOwnerId(String petName, String petType, Long ownerId) {
		Map<String, Object> param = new HashMap<>();
		param.put("petName", petName);
		param.put("petType", petType);
		param.put("ownerId", ownerId);

		return petMapper.getPetByPetNameAndTypeAndOwnerId(param);
	}

	public void updatePetById(Pet pet) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", pet.getId());
		param.put("name", pet.getName());
		param.put("type", pet.getType());
		param.put("breed", pet.getBreed());
		param.put("age", pet.getAge());
		param.put("weight", pet.getWeight());
		param.put("imageUrl", pet.getImageUrl());
		param.put("ownerId", pet.getOwnerId());

		petMapper.updatePetById(param);
	}

	public int deletePetById(Long id) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);

		return petMapper.deletePetById(param);
	}

	public List<Pet> findPetsFiltered(List<String> types) {
		Map<String, Object> param = new HashMap<>();
		param.put("types", types);

		return petMapper.findPetsFiltered(param);
	}

	public List<Pet> searchPetByOwnerName(String name) {
		Map<String, Object> param = new HashMap<>();
		param.put("ownerName", name);

		return petMapper.searchPetByOwnerName(param);
	}

	public Long findOwnerIdByPetId(Long petId) {
		Map<String, Object> param = new HashMap<>();
		param.put("petId", petId);

		return petMapper.findOwnerIdByPetId(param);
	}

	public List<Pet> getPetsByOwnerId(Long ownerId) {
		Map<String, Object> param = new HashMap<>();
		param.put("ownerId", ownerId);

		return petMapper.getPetsByOwnerId(param);
	}
	
	public int deletePetsByOwnerId(Long ownerId) {
		Map<String, Object> param = new HashMap<>();
		param.put("ownerId", ownerId);
		
		return petMapper.deletePetsByOwnerId(param);
	}

	public PetRepository(PetMapper petMapper) {
		this.petMapper = petMapper;
	}
}