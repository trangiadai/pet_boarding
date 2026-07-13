package training.javaweb.exam.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import training.javaweb.exam.dto.response.OwnerResponseDTO;
import training.javaweb.exam.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {
	private final OwnerService ownerService;

	@GetMapping
	@Operation(summary = "Get all information of owners in the database")
	@ApiResponse(responseCode = "200", description = "Successfully get all information of owners")
	public List<OwnerResponseDTO> getAllOwners() {
		return ownerService.getAllOwners();
	}

	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}
}
