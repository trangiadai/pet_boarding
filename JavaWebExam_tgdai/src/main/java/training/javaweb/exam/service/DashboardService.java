package training.javaweb.exam.service;

import org.springframework.stereotype.Service;
import training.javaweb.exam.dto.response.DashboardOverviewResponseDTO;

import training.javaweb.exam.dto.response.DashboardOverviewResponseDTO.PetTypeDistributionDTO;
import training.javaweb.exam.dto.response.RevenueDataPointDTO;
import training.javaweb.exam.repository.DashboardRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class DashboardService {
	private final DashboardRepository dashboardRepository;

	public DashboardService(DashboardRepository dashboardRepository) {
		this.dashboardRepository = dashboardRepository;
	}

	public DashboardOverviewResponseDTO getOverview() {
		DashboardOverviewResponseDTO dto = new DashboardOverviewResponseDTO();

		long totalOwners = dashboardRepository.getTotalOwners();
		long totalPets = dashboardRepository.getTotalPets();
		long activeBoarding = dashboardRepository.getActiveBoardingCount();
		long totalRevenue = dashboardRepository.getTotalRevenue();
		long totalCareNotes = dashboardRepository.getTotalCareNotes();

		List<Map<String, Object>> rawDist = dashboardRepository.getPetDistributionRaw();
		List<PetTypeDistributionDTO> distributionList = new ArrayList<>();

		if (totalPets > 0 && rawDist != null) {
			for (Map<String, Object> row : rawDist) {
				String type = (String) row.get("petType");
				long count = ((Number) row.get("typeCount")).longValue();

				double percentage = BigDecimal.valueOf((double) count / totalPets * 100)
						.setScale(2, RoundingMode.HALF_UP).doubleValue();

				distributionList.add(new PetTypeDistributionDTO(type, count, percentage));
			}
		}

		dto.setTotalOwners(totalOwners);
		dto.setTotalPets(totalPets);
		dto.setActiveBoardingCount(activeBoarding);
		dto.setTotalRevenue(totalRevenue);
		dto.setTotalCareNotes(totalCareNotes);
		dto.setPetDistribution(distributionList);

		dto.setTopBoardedPet(dashboardRepository.getTopBoardedPet());

		return dto;
	}

	public List<RevenueDataPointDTO> getRevenueAnalytics(int year, String groupBy) {
		List<RevenueDataPointDTO> result = new ArrayList<>();

		if ("quarter".equalsIgnoreCase(groupBy)) {
			List<Map<String, Object>> dbData = dashboardRepository.getQuarterlyRevenue(year);
			Map<Integer, Long> revenueMap = extractPeriodMap(dbData);

			for (int q = 1; q <= 4; q++) {
				long rev = revenueMap.getOrDefault(q, 0L);
				result.add(new RevenueDataPointDTO("Quarter " + q, q, rev));
			}
		} else {
			List<Map<String, Object>> dbData = dashboardRepository.getMonthlyRevenue(year);
			Map<Integer, Long> revenueMap = extractPeriodMap(dbData);

			for (int m = 1; m <= 12; m++) {
				long rev = revenueMap.getOrDefault(m, 0L);
				result.add(new RevenueDataPointDTO("Month " + m, m, rev));
			}
		}

		return result;
	}

	private Map<Integer, Long> extractPeriodMap(List<Map<String, Object>> dbData) {
		Map<Integer, Long> map = new HashMap<>();
		if (dbData != null) {
			for (Map<String, Object> row : dbData) {
				int period = ((Number) row.get("periodNum")).intValue();
				long totalRev = ((Number) row.get("totalRev")).longValue();
				map.put(period, totalRev);
			}
		}
		return map;
	}
}