package training.javaweb.exam.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class DashboardOverviewResponseDTO {
	@Schema(description = "E1: Total number of owners", example = "45")
	private long totalOwners;

	@Schema(description = "E1: Total number of registered pets", example = "80")
	private long totalPets;

	@Schema(description = "E1: Total pets currently boarding", example = "12")
	private long activeBoardingCount;

	@Schema(description = "E1: Total revenue accumulated across all records", example = "15000000")
	private long totalRevenue;

	@Schema(description = "E1: Total care notes logged", example = "134")
	private long totalCareNotes;

	@Schema(description = "E1: Pet distribution breakdown by type (Count and Percentage)")
	private List<PetTypeDistributionDTO> petDistribution;

	@Schema(description = "E2: Most boarded pet in system history")
	private TopBoardedPetDTO topBoardedPet;

	public static class PetTypeDistributionDTO {
		private String type;
		private long count;
		private double percentage;

		public PetTypeDistributionDTO(String type, long count, double percentage) {
			this.type = type;
			this.count = count;
			this.percentage = percentage;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public long getCount() {
			return count;
		}

		public void setCount(long count) {
			this.count = count;
		}

		public double getPercentage() {
			return percentage;
		}

		public void setPercentage(double percentage) {
			this.percentage = percentage;
		}
	}

	public static class TopBoardedPetDTO {
		private Long petId;
		private String petName;
		private String petType;
		private String ownerName;
		private long totalBoardingTimes;

		public Long getPetId() {
			return petId;
		}

		public void setPetId(Long petId) {
			this.petId = petId;
		}

		public String getPetName() {
			return petName;
		}

		public void setPetName(String petName) {
			this.petName = petName;
		}

		public String getPetType() {
			return petType;
		}

		public void setPetType(String petType) {
			this.petType = petType;
		}

		public String getOwnerName() {
			return ownerName;
		}

		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}

		public long getTotalBoardingTimes() {
			return totalBoardingTimes;
		}

		public void setTotalBoardingTimes(long totalBoardingTimes) {
			this.totalBoardingTimes = totalBoardingTimes;
		}
	}

	public long getTotalOwners() {
		return totalOwners;
	}

	public void setTotalOwners(long totalOwners) {
		this.totalOwners = totalOwners;
	}

	public long getTotalPets() {
		return totalPets;
	}

	public void setTotalPets(long totalPets) {
		this.totalPets = totalPets;
	}

	public long getActiveBoardingCount() {
		return activeBoardingCount;
	}

	public void setActiveBoardingCount(long activeBoardingCount) {
		this.activeBoardingCount = activeBoardingCount;
	}

	public long getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(long totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public long getTotalCareNotes() {
		return totalCareNotes;
	}

	public void setTotalCareNotes(long totalCareNotes) {
		this.totalCareNotes = totalCareNotes;
	}

	public List<PetTypeDistributionDTO> getPetDistribution() {
		return petDistribution;
	}

	public void setPetDistribution(List<PetTypeDistributionDTO> petDistribution) {
		this.petDistribution = petDistribution;
	}

	public TopBoardedPetDTO getTopBoardedPet() {
		return topBoardedPet;
	}

	public void setTopBoardedPet(TopBoardedPetDTO topBoardedPet) {
		this.topBoardedPet = topBoardedPet;
	}
}