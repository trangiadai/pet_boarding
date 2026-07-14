package training.javaweb.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
	public OwnerResponseDTO createOwner(OwnerRequestDTO ownerRequest) {
		return ownerService.createOwner(ownerRequest);
	}
	
	
	
	

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}
}
