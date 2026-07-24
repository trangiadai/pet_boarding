package training.javaweb.exam.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import training.javaweb.exam.repository.BoardingRecordRepository;
import training.javaweb.exam.repository.PetRepository;

@Component("securityEvaluator")
public class SecurityEvaluator {
	private final BoardingRecordRepository boardingRecordRepository;
	private final PetRepository petRepository;

	public CustomUserDetails getCurrentUserDetails() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getPrincipal() instanceof CustomUserDetails userDetails) {
			return userDetails;
		}
		return null;
	}

	public Long getCurrentOwnerId() {
		CustomUserDetails userDetails = getCurrentUserDetails();
		return userDetails != null ? userDetails.getOwnerId() : null;
	}

	public boolean isAdmin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null)
			return false;
		return auth.getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
	}

	public boolean isPetOwner(Long petId) {
		if (isAdmin())
			return true;

		Long currentOwnerId = getCurrentOwnerId();
		if (currentOwnerId == null || petId == null) {
			return false;
		}

		Long actualOwnerId = petRepository.findOwnerIdByPetId(petId);

		return currentOwnerId.equals(actualOwnerId);
	}

	public boolean canAccessBoardingRecord(Long boardingRecordId) {
		if (isAdmin()) {
			return true;
		}
		Long currentOwnerId = getCurrentOwnerId();
		if (currentOwnerId == null || boardingRecordId == null)
			return false;

		Long recordOwnerId = boardingRecordRepository.findOwnerIdByBoardingRecordId(boardingRecordId);

		return currentOwnerId.equals(recordOwnerId);
	}

	public SecurityEvaluator(BoardingRecordRepository boardingRecordRepository, PetRepository petRepository) {
		super();
		this.boardingRecordRepository = boardingRecordRepository;
		this.petRepository = petRepository;
	}

}