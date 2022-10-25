package com.mycom.myboard.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardParamDto;

//dao layer는 Controller , Service를 바라보고 코드를 작성 X, DB 등 Persistance를 보고 작성

@Mapper
public interface BoardDao {
	
	//목록
	//limit, offset
	List<BoardDto> boardList(BoardParamDto boardParamDto);
	int boardListTotalCount();
	
	//search word
	List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);
	int boardListSearchWordTotalCount(BoardParamDto boardParamDto);
	
	//상세
	BoardDto boardDetail (BoardParamDto boardParamDto);
	
	//수정
	int boardUpdate (BoardDto dto);
	
	//삭제
	int boardDelete (int boardId);
	
	//등록
	int boardInsert (BoardDto dto);
}
