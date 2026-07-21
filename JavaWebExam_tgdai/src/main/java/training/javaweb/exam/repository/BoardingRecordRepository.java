package training.javaweb.exam.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import training.javaweb.exam.dao.mapper.BoardingRecordMapper;
import training.javaweb.exam.entity.BoardingRecord;

@Repository
public class BoardingRecordRepository {
	private final BoardingRecordMapper boardingRecordMapper;

	public List<BoardingRecord> getAllRecords() {
		return boardingRecordMapper.getAllRecords();
	}

	public BoardingRecordRepository(BoardingRecordMapper boardingRecordMapper) {
		super();
		this.boardingRecordMapper = boardingRecordMapper;
	}

}
