package training.javaweb.exam.repository;

import org.springframework.stereotype.Repository;
import training.javaweb.exam.dao.mapper.DashboardMapper;
import training.javaweb.exam.dto.response.DashboardOverviewResponseDTO.TopBoardedPetDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DashboardRepository {
	private final DashboardMapper dashboardMapper;

	public DashboardRepository(DashboardMapper dashboardMapper) {
		this.dashboardMapper = dashboardMapper;
	}

	public long getTotalOwners() {
		return dashboardMapper.getTotalOwners();
	}

	public long getTotalPets() {
		return dashboardMapper.getTotalPets();
	}

	public long getActiveBoardingCount() {
		return dashboardMapper.getActiveBoardingCount();
	}

	public long getTotalRevenue() {
		return dashboardMapper.getTotalRevenue();
	}

	public long getTotalCareNotes() {
		return dashboardMapper.getTotalCareNotes();
	}

	public List<Map<String, Object>> getPetDistributionRaw() {
		return dashboardMapper.getPetDistributionRaw();
	}

	public TopBoardedPetDTO getTopBoardedPet() {
		return dashboardMapper.getTopBoardedPet();
	}

	public List<Map<String, Object>> getMonthlyRevenue(int year) {
		Map<String, Object> param = new HashMap<>();
		param.put("year", year);
		return dashboardMapper.getMonthlyRevenue(param);
	}

	public List<Map<String, Object>> getQuarterlyRevenue(int year) {
		Map<String, Object> param = new HashMap<>();
		param.put("year", year);
		return dashboardMapper.getQuarterlyRevenue(param);
	}
}