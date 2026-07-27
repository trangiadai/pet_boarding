package training.javaweb.exam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.javaweb.exam.dto.mapper.CareNoteMapperDTO;
import training.javaweb.exam.dto.request.CareNoteRequestDTO;
import training.javaweb.exam.dto.response.CareNoteResponseDTO;
import training.javaweb.exam.entity.CareNote;
import training.javaweb.exam.repository.CareNoteRepository;

@Service
public class CareNoteService {
	private final CareNoteRepository careNoteRepository;
	private final BoardingRecordService boardingRecordService;

	@Transactional
	public CareNoteResponseDTO createCareNote(CareNoteRequestDTO careNoteRequest) {
		boardingRecordService.getRecordById(careNoteRequest.getBoardingRecordId());
		
		CareNote careNote = CareNoteMapperDTO.toCareNote(careNoteRequest);
		careNoteRepository.createCareNote(careNote);

		return CareNoteMapperDTO.toCareNoteResponse(careNote);
	}

	public List<CareNoteResponseDTO> getCareNotesByBoardingRecordId(Long boardingRecordId) {

		return careNoteRepository.getCareNotesByBoardingRecordId(boardingRecordId).stream().map(careNote -> {
			return CareNoteMapperDTO.toCareNoteResponse(careNote);
		}).collect(Collectors.toList());
	}

	public CareNoteService(CareNoteRepository careNoteRepository, BoardingRecordService boardingRecordService) {
		super();
		this.careNoteRepository = careNoteRepository;
		this.boardingRecordService = boardingRecordService;
	}

}