package training.javaweb.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import training.javaweb.exam.dto.ValidationErrorDetail;
import training.javaweb.exam.dto.request.BoardingRecordRequestDTO;
import training.javaweb.exam.dto.request.CheckOutRequestDTO;
import training.javaweb.exam.dto.request.FilterRequestParam;
import training.javaweb.exam.dto.request.SearchRequestParam;
import training.javaweb.exam.dto.response.BoardingRecordResponseDTO;
import training.javaweb.exam.dto.response.MyActiveBoardingResponseDTO;
import training.javaweb.exam.security.CustomUserDetails;
import training.javaweb.exam.service.BoardingRecordService;

@RestController
@RequestMapping("/boarding-records")
public class BoardingRecordController {
	private final BoardingRecordService boardingRecordService;

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "C1. Tạo phiếu gửi mới [ADMIN]")
	@ApiResponse(responseCode = "201", description = "Successfully create new boarding record.")
	@ApiResponse(responseCode = "400", description = "Payload schema field rule constraint violation caught.", content = @Content(schema = @Schema(implementation = ValidationErrorDetail.class)))
	public BoardingRecordResponseDTO createRecord(@Valid @RequestBody BoardingRecordRequestDTO boardingRecordRequest) {
		return boardingRecordService.createRecord(boardingRecordRequest);
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "C2. Hiển thị tất cả phiếu gửi [ADMIN]")
	@ApiResponse(responseCode = "200", description = "Successfully get all information of boarding records")
	public List<BoardingRecordResponseDTO> getAllRecords() {
		return boardingRecordService.getAllRecords();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or @securityEvaluator.canAccessBoardingRecord(#id)")
	@Operation(summary = "C3. Xem chi tiết (kèm Pet, Owner, CareNotes) [ADMIN or Owner]")
	@ApiResponse(responseCode = "200", description = "Get boarding record's detail completed.")
	public BoardingRecordResponseDTO getRecordById(@PathVariable Long id) {
		return boardingRecordService.getRecordById(id);
	}

	@PostMapping("/check-out")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "C4. Trả thú cưng (check-out) [ADMIN]")
	@ApiResponse(responseCode = "200", description = "Checkout successfully.")
	@ApiResponse(responseCode = "400", description = "Payload schema field rule constraint violation caught.", content = @Content(schema = @Schema(implementation = ValidationErrorDetail.class)))
	public BoardingRecordResponseDTO checkOut(@Valid @RequestBody CheckOutRequestDTO checkOutRequest) {
		return boardingRecordService.checkOut(checkOutRequest);
	}

	@GetMapping("/active")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "C5. Danh sách đang gửi (BOARDING) [ADMIN]")
	@ApiResponse(responseCode = "200", description = "Successfully get all information of boarding records that is boarding")
	public List<BoardingRecordResponseDTO> getActiveBoardingRecords() {
		return boardingRecordService.getActiveBoardingRecords();
	}

	@GetMapping("/pet/{petId}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "C6. Lịch sử gửi theo thú cưng [ADMIN]")
	@ApiResponse(responseCode = "200", description = "Successfully get all history information of boarding records of a pet")
	public List<BoardingRecordResponseDTO> getRecordsByPetId(@PathVariable Long petId) {
		return boardingRecordService.getRecordsByPetId(petId);
	}

	@GetMapping("/owner/{ownerId}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "C7. Lịch sử gửi theo chủ nuôi [ADMIN]")
	@ApiResponse(responseCode = "200", description = "Successfully get all history information of boarding records of a owner")
	public List<BoardingRecordResponseDTO> getRecordsByOwnerId(@PathVariable Long ownerId) {
		return boardingRecordService.getRecordsByOwnerId(ownerId);
	}

	@PostMapping("/search")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "C8. Tìm kiếm theo khoảng thời gian [ADMIN]")
	@ApiResponse(responseCode = "200", description = "Successfully get all information of boarding records that is search by range of day")
	@ApiResponse(responseCode = "400", description = "Payload schema field rule constraint violation caught.", content = @Content(schema = @Schema(implementation = ValidationErrorDetail.class)))
	public List<BoardingRecordResponseDTO> searchByDateRange(
			@Valid @RequestBody SearchRequestParam searchRequestParam) {
		return boardingRecordService.searchByDateRange(searchRequestParam);
	}

	@GetMapping("/my-active")
	@PreAuthorize("hasRole('CUSTOMER')")
	@Operation(summary = "C9. Phiếu đang gửi của tôi. [CUSTOMER]")
	@ApiResponse(responseCode = "200", description = "Successfully get all information of boarding records that is boarding of the user")
	public List<MyActiveBoardingResponseDTO> getMyActiveRecords(
			@AuthenticationPrincipal CustomUserDetails userDetails) {
		return boardingRecordService.getMyActiveBoardingRecords(userDetails);
	}

	@GetMapping("/my-history")
	@PreAuthorize("hasRole('CUSTOMER')")
	@Operation(summary = "C10. Lịch sử gửi của tôi, mới nhất trước [CUSTOMER]")
	@ApiResponse(responseCode = "200", description = "Successfully get all history information of boarding records of the user")
	public List<BoardingRecordResponseDTO> getMyBoardingHistory(
			@AuthenticationPrincipal CustomUserDetails userDetails) {
		return boardingRecordService.getRecordsByOwnerId(userDetails);
	}

	@PostMapping("/filter")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "C11. Lọc phiếu gửi nâng cao [ADMIN]")
	@ApiResponse(responseCode = "200", description = "Successfully get all information of boarding records that is filtered")
	@ApiResponse(responseCode = "400", description = "Payload schema field rule constraint violation caught.", content = @Content(schema = @Schema(implementation = ValidationErrorDetail.class)))
	public List<BoardingRecordResponseDTO> filterBoardingRecords(
			@Valid @RequestBody FilterRequestParam filterRequestParam) {
		return boardingRecordService.filterBoardingRecords(filterRequestParam);
	}

	public BoardingRecordController(BoardingRecordService boardingRecordService) {
		super();
		this.boardingRecordService = boardingRecordService;
	}

}