package training.javaweb.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import training.javaweb.exam.dto.ValidationErrorDetail;
import training.javaweb.exam.dto.request.OwnerRequestDTO;
import training.javaweb.exam.dto.response.OwnerResponseDTO;
import training.javaweb.exam.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	private final OwnerService ownerService;

	@GetMapping
	@Operation(summary = "A2. Hiển thị danh sách")
	@ApiResponse(responseCode = "200", description = "Successfully get all information of owners")
	public List<OwnerResponseDTO> getAllOwners() {
		return ownerService.getAllOwners();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "A1. Thêm chủ nuôi mới")
	@ApiResponse(responseCode = "201", description = "Successfully create new customer.")
	@ApiResponse(responseCode = "400", description = "Payload schema field rule constraint violation caught.", content = @Content(schema = @Schema(implementation = ValidationErrorDetail.class)))
	public OwnerResponseDTO createOwner(@Valid @RequestBody OwnerRequestDTO ownerRequest) {
		return ownerService.createOwner(ownerRequest);
	}

	@PutMapping("/{id}")
	@Operation(summary = "A4. Cập nhật thông tin chủ nuôi")
	@ApiResponse(responseCode = "200", description = "Owner information updated successfully.")
	public OwnerResponseDTO updateOwner(@PathVariable Long id, @Valid @RequestBody OwnerRequestDTO ownerRequest) {
		return ownerService.updateOwner(id, ownerRequest);
	}

	@GetMapping("/search")
	@Operation(summary = "A5. Tìm kiếm theo tên hoặc số điện thoại")
	@ApiResponse(responseCode = "200", description = "Search query completed.")
	public List<OwnerResponseDTO> searchOwners(@RequestParam String keyword) {
		return ownerService.searchOwners(keyword);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "A7. Xóa thông tin chủ nuôi")
	@ApiResponse(responseCode = "204", description = "Owner details and their pets purged successfully.")
	public int deleteOwnerById(@PathVariable Long id) {
		return ownerService.deleteOwnerById(id);
	}

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}
}
