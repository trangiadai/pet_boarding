package training.javaweb.exam.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import training.javaweb.exam.dto.response.DashboardOverviewResponseDTO.TopBoardedPetDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface DashboardMapper {
	long getTotalOwners();

	long getTotalPets();

	long getActiveBoardingCount();

	long getTotalRevenue();

	long getTotalCareNotes();

	List<Map<String, Object>> getPetDistributionRaw();

	TopBoardedPetDTO getTopBoardedPet();

	List<Map<String, Object>> getMonthlyRevenue(Map<String, Object> param);

	List<Map<String, Object>> getQuarterlyRevenue(Map<String, Object> param);
}