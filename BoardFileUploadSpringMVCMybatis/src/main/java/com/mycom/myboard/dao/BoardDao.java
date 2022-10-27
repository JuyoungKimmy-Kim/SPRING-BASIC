package com.mycom.myboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardFileDto;
import com.mycom.myboard.dto.BoardParamDto;

// dao layer 는 Controller, Service 를 바라보고 코드를 작성 X, DB 등 Persistance 를 보고 작성
@Mapper
public interface BoardDao {
	
	// 목록
	// limit, offset
	List<BoardDto> boardList(BoardParamDto baordParamDto);
	int boardListTotalCount();
	
	// searchWord
	List<BoardDto> boardListSearchWord(BoardParamDto baordParamDto);
	int boardListSearchWordTotalCount(BoardParamDto baordParamDto);
	
	// 상세
	BoardDto boardDetail(BoardParamDto boardParamDto);
	
	// 수정
	int boardUpdate(BoardDto dto);
	
	// 삭제
	int boardDelete(int boardId);
	int boardFileDelete(int boardId);
	int boardReadCountDelete(int boardId);
	
	List<String> boardFileUrlDeleteList(int bordId);
	
	// 등록
	int boardInsert(BoardDto dto);				// 게시글 등록
	int boardFileInsert (BoardFileDto dto);		// 첨부 파일 등록
}
