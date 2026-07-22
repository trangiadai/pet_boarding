package training.javaweb.exam.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import training.javaweb.exam.dto.request.BoardingRecordRequestDTO;
import training.javaweb.exam.dto.request.FilterRequestParam;
import training.javaweb.exam.dto.request.SearchRequestParam;
import training.javaweb.exam.dto.response.BoardingRecordResponseDTO;
import training.javaweb.exam.service.BoardingRecordService;

@RestController
@RequestMapping("/boarding-records")
public class BoardingRecordController {
	private final BoardingRecordService boardingRecordService;

	@PostMapping
	public BoardingRecordResponseDTO createRecord(@Valid @RequestBody BoardingRecordRequestDTO boardingRecordRequest,
			@RequestParam(required = true) Long dailyFee) {
		return boardingRecordService.createRecord(boardingRecordRequest, dailyFee);
	}

	@GetMapping
	public List<BoardingRecordResponseDTO> getAllRecords() {
		return boardingRecordService.getAllRecords();
	}

	@GetMapping("/{id}")
	public BoardingRecordResponseDTO getRecordById(@PathVariable Long id) {
		return boardingRecordService.getRecordById(id);
	}
// TODO: fix this method in the next day (not complete yet)
//	@PostMapping("/{id}/check-out")
//	public BoardingRecordResponseDTO checkOut(@PathVariable Long id,
//			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate actualCheckOut,
//			@RequestParam(required = true) Long dailyRate) {
//		return boardingRecordService.checkOut(id, actualCheckOut, dailyRate);
//	}

	@GetMapping("/active")
	public List<BoardingRecordResponseDTO> getActiveBoardingRecords() {
		return boardingRecordService.getActiveBoardingRecords();
	}

	@GetMapping("/pet/{petId}")
	public List<BoardingRecordResponseDTO> getRecordsByPetId(@PathVariable Long petId) {
		return boardingRecordService.getRecordsByPetId(petId);
	}

	@GetMapping("/owner/{ownerId}")
	public List<BoardingRecordResponseDTO> getRecordsByOwnerId(@PathVariable Long ownerId) {
		return boardingRecordService.getRecordsByOwnerId(ownerId);
	}

	@PostMapping("/search")
	public List<BoardingRecordResponseDTO> searchByDateRange(
			@Valid @RequestBody SearchRequestParam searchRequestParam) {
		return boardingRecordService.searchByDateRange(searchRequestParam);
	}

//	TODO: this method isn't finish yet (waiting for adding security) (create util class to verify username is number)
//	@GetMapping("/my-active")
//	public List<MyActiveBoardingResponseDTO> getMyActiveBoarding(Long userName, @RequestParam(defaultValue = "100000") Long dailyRate) {
//		return boardingRecordService.getMyActiveBoarding(ownerId, dailyRate);
//	}

	// TODO: My history boarding

	@PostMapping("/filter")
	public List<BoardingRecordResponseDTO> filterBoardingRecords(
			@Valid @RequestBody FilterRequestParam filterRequestParam) {
		return boardingRecordService.filterBoardingRecords(filterRequestParam);
	}

	public BoardingRecordController(BoardingRecordService boardingRecordService) {
		super();
		this.boardingRecordService = boardingRecordService;
	}

}