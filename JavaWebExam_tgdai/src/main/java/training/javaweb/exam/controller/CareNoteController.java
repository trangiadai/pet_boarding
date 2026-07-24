package training.javaweb.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import training.javaweb.exam.dto.ValidationErrorDetail;
import training.javaweb.exam.dto.request.CareNoteRequestDTO;
import training.javaweb.exam.dto.response.CareNoteResponseDTO;
import training.javaweb.exam.service.CareNoteService;

@RestController
@RequestMapping("/care-notes")
public class CareNoteController {
	private final CareNoteService careNoteService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	@ApiResponse(responseCode = "201", description = "Successfully create new care note.")
	@ApiResponse(responseCode = "400", description = "Payload schema field rule constraint violation caught.", content = @Content(schema = @Schema(implementation = ValidationErrorDetail.class)))
	public CareNoteResponseDTO createCareNote(@Valid @RequestBody CareNoteRequestDTO careNoteRequest) {
		return careNoteService.createCareNote(careNoteRequest);
	}

	@GetMapping("/record/{recordId}")
	@PreAuthorize("@securityEvaluator.canAccessBoardingRecord(#recordId)")
	@ApiResponse(responseCode = "200", description = "Successfully get all information of the care notes that belong to the boarding record")
	public List<CareNoteResponseDTO> getCareNotesByBoardingRecordId(@PathVariable Long recordId) {
		return careNoteService.getCareNotesByBoardingRecordId(recordId);
	}

	public CareNoteController(CareNoteService careNoteService) {
		super();
		this.careNoteService = careNoteService;
	}

}