package training.javaweb.exam.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import training.javaweb.exam.entity.Pet;

@Mapper
public interface PetMapper{
    int createPet(Map<String, Object> param);
    
    List<Pet> getAllPets();

    Pet getPetById(Map<String, Object> param);
    
    int updatePetById(Map<String, Object> param);
    
    int deletePetById(Map<String, Object> param);
    
    List<Pet> findPetsFiltered(Map<String, Object> param);
}