package training.javaweb.exam.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import training.javaweb.exam.dto.response.DashboardOverviewResponseDTO;
import training.javaweb.exam.dto.response.RevenueDataPointDTO;
import training.javaweb.exam.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
@PreAuthorize("hasRole('ADMIN')")
public class DashboardController {
	private final DashboardService dashboardService;

	public DashboardController(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	@GetMapping("/overview")
	@Operation(summary = "E1 & E2. Tổng quan hệ thống & Thú cưng gửi nhiều nhất [ADMIN]")
	@ApiResponse(responseCode = "200", description = "Successfully get the information of the overview information of the system")
	public DashboardOverviewResponseDTO getOverview() {
		return dashboardService.getOverview();
	}

	@GetMapping("/revenue")
	@Operation(summary = "E3. Doanh thu theo tháng hoặc theo quý [ADMIN]")
	@ApiResponse(responseCode = "200", description = "Successfully get the information of the revenue of the system")
	public List<RevenueDataPointDTO> getRevenueAnalytics(@RequestParam(required = false) Integer year,
			@RequestParam(defaultValue = "month") String groupBy) {

		int targetYear = (year != null) ? year : LocalDate.now().getYear();
		return dashboardService.getRevenueAnalytics(targetYear, groupBy);
	}
}