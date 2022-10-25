package com.mycom.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.dao.BoardDao;
import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;

// Controller의 요청에 의해 필요한 파라미터는 받고, 원하는 결과 데이터를 만들어서 리턴
// Business Logic의 핵심은 바로 Service layer에서 !

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao dao;
	
	private final int SUCCESS=1;
	private final int FAIL=-1;
	
	@Override
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto=new BoardResultDto();
		try {
			//목록, 총 건수를 가져옴
			List<BoardDto> list=dao.boardList(boardParamDto);
			int count=dao.boardListTotalCount();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			
			boardResultDto.setResult(SUCCESS);
			
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto=new BoardResultDto();
		try {
			//목록, 총 건수를 가져옴
			List<BoardDto> list=dao.boardListSearchWord(boardParamDto);
			int count=dao.boardListSearchWordTotalCount(boardParamDto);
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			
			boardResultDto.setResult(SUCCESS);
			
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardDetail(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto=new BoardResultDto();

		try {
			// DB에서 게시글 정보를 가져옴 
			BoardDto boardDto=dao.boardDetail(boardParamDto);
			// 게시글 작성자와 현재 상세 조회하는 사용자의 동일인 여부 확인
			if (boardDto.getUserSeq()==boardParamDto.getUserSeq()) {
				boardDto.setSameUser(true);
			} else {
				boardDto.setSameUser(false);
			}

			//boardResultDto의 일부인 boardDto를 설정
			boardResultDto.setDto(boardDto);
			boardResultDto.setResult(SUCCESS);
			
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardUpdate(BoardDto boardDto) {
		BoardResultDto boardResultDto=new BoardResultDto();

		try {
			int ret=dao.boardUpdate(boardDto);
			if (ret==1) {
				boardResultDto.setResult(SUCCESS);
			} else {
				boardResultDto.setResult(FAIL);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardDelete(int boardId) {
		BoardResultDto boardResultDto=new BoardResultDto();

		try {
			int ret=dao.boardDelete(boardId);
			if (ret==1) {
				boardResultDto.setResult(SUCCESS);
			} else {
				boardResultDto.setResult(FAIL);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardInsert(BoardDto boardDto) {
		BoardResultDto boardResultDto=new BoardResultDto();

		try {
			int ret=dao.boardInsert(boardDto);
			if (ret==1) {
				boardResultDto.setResult(SUCCESS);
			} else {
				boardResultDto.setResult(FAIL);
			}		
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		return boardResultDto;
	}
}
